package gui;
import Controlador.Alumno;
import service.AlumnoService;
import service.ServiceException;


import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

//Clase FormularioAlumno que extiende JPanel para la creación del formulario de Alumno
public class FormularioAlumno extends JPanel {

    AlumnoService alumnoService;
    PanelManager panel;
    JPanel formularioAlumno;
    JLabel jLabelLegajo;
    JLabel jLabelNombre;
    JLabel jLabelApellido;
    JTextField jTextFieldLegajo;
    JTextField jTextFieldNombre;
    JTextField jTextFieldApellido;
    JButton jButtonGuardar;
    JButton jButtonNuevo;
    JButton jButtonMostrarLista;
    JPanel jPanelBotones;
    DefaultListModel<String> listModel; // Modelo de lista para JList
    JList<String> jListAlumnos; // JList para mostrar los alumnos
    DefaultTableModel tableModel; // Modelo de tabla para JTable
    JTable jTableAlumnos; // JTable para mostrar los alumnos
    
    // Constructor de la clase FormularioAlumno que recibe un PanelManager como parámetro
    public FormularioAlumno(PanelManager panel) {
        this.panel = panel;
        listModel = new DefaultListModel<>(); // Inicializar el modelo de lista
        jListAlumnos = new JList<>(listModel); // Inicializar la JList con el modelo
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Legajo");
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Apellido");
        jTableAlumnos = new JTable(tableModel);
        armarFormularioAlumno();
    }

    // Método para configurar y construir el formulario de Alumno
    public void armarFormularioAlumno() {
        alumnoService = new AlumnoService();
        formularioAlumno = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        jLabelLegajo = new JLabel("Legajo:");
        jLabelNombre = new JLabel("Nombre:");
        jLabelApellido = new JLabel("Apellido:");

        jTextFieldLegajo = new JTextField(20);
        jTextFieldNombre = new JTextField(20);
        jTextFieldApellido = new JTextField(20);
        
        jButtonGuardar = new JButton("Guardar");
        jButtonNuevo = new JButton("Nuevo");
        jButtonMostrarLista = new JButton("Mostrar Lista");

        jPanelBotones = new JPanel();
        jPanelBotones.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        gbc.gridx = 0;
        gbc.gridy = 0;
        formularioAlumno.add(jLabelLegajo, gbc);

        gbc.gridy = 1;
        formularioAlumno.add(jLabelNombre, gbc);

        gbc.gridy = 2;
        formularioAlumno.add(jLabelApellido, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        formularioAlumno.add(jTextFieldLegajo, gbc);

        gbc.gridy = 1;
        formularioAlumno.add(jTextFieldNombre, gbc);

        gbc.gridy = 2;
        formularioAlumno.add(jTextFieldApellido, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 10, 10, 10);
        formularioAlumno.add(jPanelBotones, gbc);

        setLayout(new BorderLayout());
        add(formularioAlumno, BorderLayout.CENTER);

        jPanelBotones.add(jButtonGuardar);
        jPanelBotones.add(Box.createRigidArea(new Dimension(10, 0)));
        jPanelBotones.add(jButtonNuevo);
        jPanelBotones.add(jButtonMostrarLista);

        // Acción al presionar el botón "Guardar"
        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // Crear un nuevo objeto Alumno con los datos ingresados
                Alumno alumno = new Alumno();
                alumno.setLegajo(jTextFieldLegajo.getText());
                alumno.setNombre(jTextFieldNombre.getText());
                alumno.setApellido(jTextFieldApellido.getText());
                try {
                	// Llamar al servicio para guardar al alumno
                    alumnoService.guardarAlumno(alumno);
                 // Agregar el alumno al modelo de lista y mostrar mensaje de éxito
                    listModel.addElement("Legajo: " + alumno.getLegajo() + ", Nombre: " + alumno.getNombre() + ", Apellido: " + alumno.getApellido());
                    JOptionPane.showMessageDialog(null, "Se guardo correctamente");
                } catch (ServiceException serEx) {
                	 // Mostrar mensaje de error en caso de fallo al guardar
                    JOptionPane.showMessageDialog(null, "No se pudo guardar");
                }
            }
        });

     // Acción al presionar el botón "Mostrar Lista"
        jButtonMostrarLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Llamar al método para mostrar la tabla de alumnos
            	mostrarTablaAlumnos(); 
            }
        });
        
        // Acción al presionar el botón "Nuevo"
      jButtonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                	 // Limpiar los campos de texto al presionar el botón "Nuevo"
                    jTextFieldLegajo.setText("");
                    jTextFieldNombre.setText("");
                    jTextFieldApellido.setText("");
                } catch (Exception ex) {
                	// Mostrar mensaje de error en caso de fallo al limpiar
                    JOptionPane.showMessageDialog(null, "No se puede crear nuevo");
                }
            }
        });
        
    }

    // Método para mostrar la tabla de alumnos en una nueva ventana
    public void mostrarTablaAlumnos() {
        // Crear una nueva ventana para mostrar la tabla
        JFrame frame = new JFrame();
        frame.setSize(600, 400);

        // Crear un JScrollPane para la JTable
        JScrollPane jScrollPane = new JScrollPane(jTableAlumnos);
        frame.add(jScrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

        // Limpiar la tabla antes de agregar los datos
        tableModel.setRowCount(0);

        // Obtener los elementos del modelo de lista jListAlumnos
     for (int i = 0; i < listModel.size(); i++) {
            String[] parts = listModel.get(i).split(", ");
            String legajo = parts[0].substring(8); // obtener el legajo del texto
            String nombre = parts[1].substring(8); // obtener el nombre del texto
            String apellido = parts[2].substring(10); // obtener el apellido del texto
            tableModel.addRow(new Object[]{legajo, nombre, apellido});
        }
        
 

        // Crear un botón de eliminación
        JButton eliminarButton = new JButton("Eliminar");
        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTableAlumnos.getSelectedRow();
                if (selectedRow != -1) {
                    String legajo = (String) tableModel.getValueAt(selectedRow, 0);
                    try {
                        alumnoService.eliminarAlumno(legajo);
                        listModel.remove(selectedRow);
                        tableModel.removeRow(selectedRow);
                        JOptionPane.showMessageDialog(null, "Se eliminó correctamente");
                    } catch (ServiceException ex) {
                        JOptionPane.showMessageDialog(null, "No se pudo eliminar");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un alumno para eliminar");
                }
            }
        });
/*
        // Crear un botón de modificación
        JButton modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTableAlumnos.getSelectedRow();
                if (selectedRow != -1) {
                    // Aquí puedes implementar la lógica de modificación del alumno seleccionado
                    JOptionPane.showMessageDialog(null, "Funcionalidad de modificación en proceso");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un alumno para modificar");
                }
            }
        });
        */
        // Crear un botón de modificación
        JButton modificarButton = new JButton("Modificar");
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = jTableAlumnos.getSelectedRow();
                if (selectedRow != -1) {
                    String selectedLegajo = (String) tableModel.getValueAt(selectedRow, 0);
                    String nombre = (String) tableModel.getValueAt(selectedRow, 1);
                    String apellido = (String) tableModel.getValueAt(selectedRow, 2);

                    // Prompt the user for the modified values
                    String nuevoNombre = JOptionPane.showInputDialog("Nuevo nombre:", nombre);
                    String nuevoApellido = JOptionPane.showInputDialog("Nuevo apellido:", apellido);

                    // Create a new Alumno object with the modified values
                    Alumno alumnoModificado = new Alumno();
                    alumnoModificado.setLegajo(selectedLegajo);
                    alumnoModificado.setNombre(nuevoNombre);
                    alumnoModificado.setApellido(nuevoApellido);

                    try {
                        alumnoService.modificarAlumno(alumnoModificado);
                        listModel.setElementAt("Legajo: " + alumnoModificado.getLegajo() +
                                ", Nombre: " + alumnoModificado.getNombre() +
                                ", Apellido: " + alumnoModificado.getApellido(), selectedRow);
                        tableModel.setValueAt(alumnoModificado.getLegajo(), selectedRow, 0);
                        tableModel.setValueAt(alumnoModificado.getNombre(), selectedRow, 1);
                        tableModel.setValueAt(alumnoModificado.getApellido(), selectedRow, 2);
                        JOptionPane.showMessageDialog(null, "Alumno modificado correctamente");
                    } catch (ServiceException ex) {
                        JOptionPane.showMessageDialog(null, "No se pudo modificar el alumno");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un alumno para modificar");
                }
            }
        });

        

        // Agregar los botones de eliminación y modificación a la ventana
        JPanel panelBotones = new JPanel();
        panelBotones.add(eliminarButton);
        panelBotones.add(modificarButton);
        frame.add(panelBotones, BorderLayout.SOUTH);
    }

    
}





/*
package gui;
import Controlador.Alumno;
import service.AlumnoService;
import service.ServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormularioAlumno extends JPanel {

    AlumnoService alumnoService;
    PanelManager panel;
    JPanel formularioAlumno;
    JLabel jLabelLegajo;
    JLabel jLabelNombre;
    JLabel jLabelApellido;
    JTextField jTextFieldLegajo;
    JTextField jTextFieldNombre;
    JTextField jTextFieldApellido;
    JButton jButtonGuardar;
    JButton jButtonNuevo;
    JButton jButtonMostrarLista;
    JPanel jPanelBotones;
    DefaultListModel<String> listModel; // Modelo de lista para JList
    JList<String> jListAlumnos; // JList para mostrar los alumnos

    public FormularioAlumno(PanelManager panel) {
        this.panel = panel;
        listModel = new DefaultListModel<>(); // Inicializar el modelo de lista
        jListAlumnos = new JList<>(listModel); // Inicializar la JList con el modelo
        armarFormularioAlumno();
    }

    public void armarFormularioAlumno() {
        alumnoService = new AlumnoService();
        formularioAlumno = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        jLabelLegajo = new JLabel("Legajo:");
        jLabelNombre = new JLabel("Nombre:");
        jLabelApellido = new JLabel("Apellido:");

        jTextFieldLegajo = new JTextField(20);
        jTextFieldNombre = new JTextField(20);
        jTextFieldApellido = new JTextField(20);
        
        jButtonGuardar = new JButton("Guardar");
        jButtonNuevo = new JButton("Nuevo");
        jButtonMostrarLista = new JButton("Mostrar Lista");

        jPanelBotones = new JPanel();
        jPanelBotones.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        gbc.gridx = 0;
        gbc.gridy = 0;
        formularioAlumno.add(jLabelLegajo, gbc);

        gbc.gridy = 1;
        formularioAlumno.add(jLabelNombre, gbc);

        gbc.gridy = 2;
        formularioAlumno.add(jLabelApellido, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        formularioAlumno.add(jTextFieldLegajo, gbc);

        gbc.gridy = 1;
        formularioAlumno.add(jTextFieldNombre, gbc);

        gbc.gridy = 2;
        formularioAlumno.add(jTextFieldApellido, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(20, 10, 10, 10);
        formularioAlumno.add(jPanelBotones, gbc);

        setLayout(new BorderLayout());
        add(formularioAlumno, BorderLayout.CENTER);

        jPanelBotones.add(jButtonGuardar);
        jPanelBotones.add(Box.createRigidArea(new Dimension(10, 0)));
        jPanelBotones.add(jButtonNuevo);
        jPanelBotones.add(jButtonMostrarLista);

        jButtonGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Alumno alumno = new Alumno();
                alumno.setLegajo(jTextFieldLegajo.getText());
                alumno.setNombre(jTextFieldNombre.getText());
                alumno.setApellido(jTextFieldApellido.getText());
                try {
                    alumnoService.guardarAlumno(alumno);
                    listModel.addElement("Legajo: " + alumno.getLegajo() + ", Nombre: " + alumno.getNombre() + ", Apellido: " + alumno.getApellido());
                    JOptionPane.showMessageDialog(null, "Se guardo correctamente");
                } catch (ServiceException serEx) {
                    JOptionPane.showMessageDialog(null, "No se pudo guardar");
                }
            }
        });

        jButtonMostrarLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, new JScrollPane(jListAlumnos), "Lista de Alumnos", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
      jButtonNuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    jTextFieldLegajo.setText("");
                    jTextFieldNombre.setText("");
                    jTextFieldApellido.setText("");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "No se puede crear nuevo");
                }
            }
        });
        
    }
}
*/
