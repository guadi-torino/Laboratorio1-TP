package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
//Clase PanelManager para gestionar la interfaz gráfica
public class PanelManager {
    private FormularioAlumno formularioAlumno;
    JFrame ventana;
    
 // Constructor de la clase PanelManager
    public PanelManager()
    {
    	// Crear una nueva instancia de JFrame
        ventana=new JFrame();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Crear una instancia de FormularioAlumno
        formularioAlumno=new FormularioAlumno(this);
     // Mostrar el formulario de alumno
        mostrar(formularioAlumno);

    }
    
 // Método para mostrar un panel en la ventana
    public void mostrar(JPanel panel)
    {
    	// Limpiar el contenido actual de la ventana
        ventana.getContentPane().removeAll();
     // Agregar el panel al área inferior de la ventana
        ventana.getContentPane().add(BorderLayout.SOUTH,panel);
        // Validar y repintar la ventana para reflejar los cambios
        ventana.getContentPane().validate();
        ventana.getContentPane().repaint();
        // Hacer visible la ventana
        ventana.show();
     // Ajustar el tamaño de la ventana automáticamente
        ventana.pack();
    }

}

/*
    private JFrame ventana;
    private JPanel panelInicio;
    private JPanel panelReportes;
    private FormularioUsuario formularioUsuario;

    public PanelManager(FormularioUsuario formularioUsuario) {
        this.formularioUsuario = formularioUsuario;
    }

    public void mostrarVentana() {
        ventana = new JFrame("Sistema de Cursos");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panelInicio = new JPanel();
        panelReportes = new JPanel();

        JButton btnReportes = new JButton("Ver Reportes");
        btnReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelReportes();
            }
        });

        panelInicio.add(btnReportes);

        ventana.getContentPane().add(panelInicio);
        ventana.setSize(300, 200);
        ventana.setVisible(true);
    }

    private void mostrarPanelReportes() {
        panelInicio.setVisible(false);
        panelReportes.removeAll();

        JTextArea textAreaReportes = new JTextArea(10, 30);
        textAreaReportes.setEditable(false);

        JButton btnEmitirReportes = new JButton("Emitir Reportes");
        btnEmitirReportes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               //String reportes = formularioUsuario.getAdmin().emitirReporteCursos() + "\n\n" +
            //            formularioUsuario.getAdmin().emitirReporteRecaudacion() + "\n\n" +
                        formularioUsuario.getCurso1().emitirReporteAnotadosVsAprobados();

          //      textAreaReportes.setText(reportes);
            }
        });

        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPanelInicio();
            }
        });

        panelReportes.add(new JScrollPane(textAreaReportes));
        panelReportes.add(btnEmitirReportes);
        panelReportes.add(btnVolver);

        ventana.getContentPane().add(panelReportes);
        ventana.setSize(500, 400);
        ventana.revalidate();
        ventana.repaint();
    }

    private void mostrarPanelInicio() {
        panelReportes.setVisible(false);
        panelInicio.setVisible(true);
        ventana.setSize(300, 200);
        ventana.revalidate();
        ventana.repaint();
    }
    */

