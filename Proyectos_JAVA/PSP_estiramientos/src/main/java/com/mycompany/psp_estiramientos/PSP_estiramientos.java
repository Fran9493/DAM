package com.mycompany.psp_estiramientos;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Fran
 */
public class PSP_estiramientos {

    public static void main(String[] args) {

        long tiempo = 30 * 60 * 1000;

        Timer temporizador = new Timer();
        TimerTask tarea = new TimerTask() {

            @Override
            public void run() {

                recordarUsuario();

            }

        };

        temporizador.scheduleAtFixedRate(tarea, 0, tiempo);

    }

    private static void recordarUsuario() {

        SystemTray st = SystemTray.getSystemTray();
        Image im = Toolkit.getDefaultToolkit().getImage("C:\\Users\\Fran\\OneDrive\\Documents\\2FPGS_DAM\\Programacion_Servicios\\Tareas\\Tema2\\ActiveHours.png");
        TrayIcon ti = new TrayIcon(im, "Recuerda");
        ti.setImageAutoSize(true);

        try {

            st.add(ti);

        } catch (AWTException ex) {

            System.out.println("Error: " + ex.getMessage());

        }

        ti.displayMessage("Estirar las piernas", "Levántante, que ya va siendo hora", TrayIcon.MessageType.INFO);

    }
}
