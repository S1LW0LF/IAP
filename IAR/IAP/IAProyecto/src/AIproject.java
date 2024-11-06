import java.sql.Connection;
import java.sql.ResultSet;
import javax.swing.*;
import java.util.List;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.table.DefaultTableModel;

public class AIproject {

    public static void main(String[] args) {
        
        
   
        
// Crear la ventana principal
JFrame mainFrame = new JFrame("Menú Principal");
mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

// Configuración para pantalla completa
mainFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizar la ventana
mainFrame.setUndecorated(true);  // Elimina los bordes y el título de la ventana

mainFrame.setLayout(null);


        // Crear la imagen de fondo
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\IAU2.jpg");
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 1920, 1080); // Ajustar al tamaño de la ventana
        
        // Crear el texto de bienvenida
        JLabel welcomeLabel = new JLabel("<html>INSTITUTO TECNOLOGICO DE ZACATEPEC<br><br>Nombre: LORENCILLA CARVAJAL JESÚS EMMANUEL"
                + "<br><br>No.de control: 20091120<br><br>'SISTEMAS EXPERTO PARA EL DIAGNOSTICO DE ENFERMEDADES'</html>", SwingConstants.CENTER);
        welcomeLabel.setBounds(400, 50, 800, 600); // Ajustar el tamaño y posición del texto
        welcomeLabel.setFont(new Font("Serif", Font.BOLD, 24)); // Tipo de letra "Serif", negrita, tamaño 24
        welcomeLabel.setForeground(Color.WHITE); // Cambiar el color del texto
        
        // Redimensionar y establecer las imágenes en las esquinas superiores
        ImageIcon topLeftIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\Tecnm.jpg");
        Image topLeftImage = topLeftIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel topLeftImageLabel = new JLabel(new ImageIcon(topLeftImage));
        topLeftImageLabel.setBounds(50, 50, 150, 150); // Ajustar posición y tamaño

        ImageIcon topRightIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\ITZLogo.jpg");
        Image topRightImage = topRightIcon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
        JLabel topRightImageLabel = new JLabel(new ImageIcon(topRightImage));
        topRightImageLabel.setBounds(1300, 50, 150, 150); // Ajustar posición y tamaño

    // Crear los botones
JButton button1 = new JButton("Acerca De...");
JButton button3 = new JButton("Entrar");
JButton button4 = new JButton("Salir");

// Crear los iconos para los botones
ImageIcon iconButton1 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\icono1.png");
ImageIcon iconButton3 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\icono3.png");
ImageIcon iconButton4 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\icono4.png");

// Redimensionar los iconos para ajustarlos a los botones
Image iconImage1 = iconButton1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
Image iconImage3 = iconButton3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
Image iconImage4 = iconButton4.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

// Asignar los iconos redimensionados a los botones
button1.setIcon(new ImageIcon(iconImage1));
button3.setIcon(new ImageIcon(iconImage3));
button4.setIcon(new ImageIcon(iconImage4));

// Posicionar los iconos en el texto
button1.setHorizontalTextPosition(SwingConstants.RIGHT);
button1.setVerticalTextPosition(SwingConstants.CENTER);

button3.setHorizontalTextPosition(SwingConstants.RIGHT);
button3.setVerticalTextPosition(SwingConstants.CENTER);

button4.setHorizontalTextPosition(SwingConstants.RIGHT);
button4.setVerticalTextPosition(SwingConstants.CENTER);

// Posicionar los botones
button1.setBounds(1200, 600, 150, 50);
button3.setBounds(1200, 720, 150, 50);
button4.setBounds(100, 720, 150, 50);


        // Agregar los componentes a la ventana
        mainFrame.add(welcomeLabel);
        backgroundLabel.add(topLeftImageLabel);
        backgroundLabel.add(topRightImageLabel);
        mainFrame.add(button1);
        mainFrame.add(button3);
        mainFrame.add(button4);

        
        
        
        
        
  //-------------------------------------------------Añadir acción a los botones-------------------------------------------------------------------
     


   button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMessage("Acerca del Sistema", 
                        "<html><br><div style='text-align: center;'><b>Version 1</b></div><br>-----------------------------------------------------------------------------------------<br>"
                                + "Este SW es para uso exclusivo de la materia de IA de la Carrera de Ing. en Sistemas..."
                                + "<br>-----------------------------------------------------------------------------------------</html>",
                        "C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\IA.png");
            }
        });


    button3.addActionListener(new ActionListener() {
           
            public void actionPerformed(ActionEvent e) {
              
                mostrarMenuUsuarioExperto(); 
            }
        });


button4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Cierra la aplicación
            }
        });

        // Establecer el orden de los componentes para que el fondo esté detrás
        mainFrame.getContentPane().add(backgroundLabel);
        mainFrame.setVisible(true);
    }
    
//-------------------------------------------------------------------------------------------------------------------------------------------------
    
    
    
    
    
//----------------------------------------------------Metodos para el Boton ACERCA DE---------------------------------------------------------------------- 
    private static void showMessage(String title, String additionalText, String imagePath) {
        JFrame messageFrame = new JFrame(title);
        // Configuración para pantalla completa
    messageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizar la ventana
    messageFrame.setUndecorated(true);  // Eliminar bordes y título de la ventana

    messageFrame.setLayout(null);

        // Crear la imagen de fondo
        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\fondo2.jpg"); // Ruta de la imagen de fondo
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 1920, 1080); // Ajustar al tamaño del JFrame

        // Crear un título en la ventana emergente
        JLabel titleLabel = new JLabel("<html><b>" + title + "</b></html>", SwingConstants.CENTER);
        titleLabel.setBounds(400, 30, 700, 40);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 36)); // Tipo de letra Serif, tamaño 36

        // Crear una imagen en la ventana emergente
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH); // Ajustar tamaño
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(500, 80, 500, 300); // Ajustar la posición y el tamaño

        // Crear texto adicional
        JLabel additionalTextLabel = new JLabel("<html><b>" + additionalText + "</b><html>", SwingConstants.CENTER);
        additionalTextLabel.setBounds(400, 200, 800, 600);
        additionalTextLabel.setFont(new Font("Serif", Font.PLAIN, 24)); // Tipo de letra Serif, tamaño 24         

         
        
         // Crear un botón de Autores
        JButton BotonAutores = new JButton("Autores");
        BotonAutores.setBounds(1200, 600, 150, 50); // Posicionar el botón de regresar en la parte inferior derecha
        // Crear los iconos para los botones
         ImageIcon iconButton6 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\grupo.png");

         // Redimensionar los iconos para ajustarlos a los botones
         Image iconImage2 = iconButton6.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

         // Asignar los iconos redimensionados a los botones
         BotonAutores.setIcon(new ImageIcon(iconImage2));

         // Posicionar los iconos en el texto
        BotonAutores.setHorizontalTextPosition(SwingConstants.RIGHT);
        BotonAutores.setVerticalTextPosition(SwingConstants.CENTER);
        BotonAutores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Autores("Autores del Sistema", "<html>DATOS PERSONALES:<br><br>Nombre: LORENCILLA CARVAJAL JESÚS EMMANUEL<br>Direccion: Jojutla Mor."
                        + "<br>Telefono: 777 145 7454<br>Email: jesus@gmail.com</html>",
                       "<html>DATOS PERSONALES:<br><br>Nombre: Many<br>Raza: Pug<br> Edad: 3 Años</html>",
                        "C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\perfil.jpg", 
                        "C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\pug.jpg");
            }
        }); 
        
        
        
        // Crear un botón de regresar
        JButton backButton = new JButton("Regresar");
        backButton.setBounds(1200, 720, 150, 50); // Posicionar el botón de regresar en la parte inferior derecha
        // Crear los iconos para los botones
         ImageIcon iconButton5 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\icono.png");

         // Redimensionar los iconos para ajustarlos a los botones
         Image iconImage1 = iconButton5.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

         // Asignar los iconos redimensionados a los botones
         backButton.setIcon(new ImageIcon(iconImage1));

         // Posicionar los iconos en el texto
         backButton.setHorizontalTextPosition(SwingConstants.RIGHT);
         backButton.setVerticalTextPosition(SwingConstants.CENTER);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageFrame.dispose(); // Cierra la ventana emergente
            }
        });
        
      

        // Agregar componentes a la ventana emergente
        messageFrame.add(titleLabel);
        messageFrame.add(imageLabel);
        messageFrame.add(additionalTextLabel);
        messageFrame.add(backButton);
        messageFrame.add(BotonAutores);

        // Añadir la imagen de fondo
        messageFrame.getContentPane().add(backgroundLabel);
        
        messageFrame.setVisible(true);
    }
 //------------------------------------------------------------------------------------------------------------------------------------    
      
    
    
    
    
    
//----------------------------------------------------------BOTON AUTORES-------------------------------------------------------------------------
     private static void Autores(String title, 
            String additionalText, 
            String additionalText2, 
    
            String imagePath,
            String imagePath2
           ) {
        JFrame messageFrame = new JFrame(title);
       messageFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizar la ventana
    messageFrame.setUndecorated(true);  // Eliminar bordes y título de la ventana

    messageFrame.setLayout(null);
        
    ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\fondo2.jpg"); // Ruta de la imagen de fondo
    Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
    JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
    backgroundLabel.setBounds(0, 0, 1920, 1080); // Ajustar al tamaño del JFrame
         
         // Crear un título en la ventana emergente
        JLabel titleLabel = new JLabel("<html><b>" + title + "</b></html>", SwingConstants.CENTER);
        titleLabel.setBounds(400, 10, 700, 40);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 40)); // Tipo de letra Arial, tamaño 18

        // Crear una imagen en la ventana emergente 1
        ImageIcon imageIcon = new ImageIcon(imagePath);
        Image image = imageIcon.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH); // Ajustar tamaño
        JLabel imageLabel = new JLabel(new ImageIcon(image));
        imageLabel.setBounds(15, 70, 400, 350); // Ajustar la posición y el tamaño
        
        // Crear una imagen en la ventana emergente 2
        ImageIcon imageIcon2 = new ImageIcon(imagePath2);
        Image image2 = imageIcon2.getImage().getScaledInstance(300, 400, Image.SCALE_SMOOTH); // Ajustar tamaño
        JLabel imageLabel2 = new JLabel(new ImageIcon(image2));
        imageLabel2.setBounds(15, 435, 400, 350); // Ajustar la posición y el tamaño
         
  
        // Crear texto adicional 1
        JLabel additionalTextLabel = new JLabel("<html><b>" + additionalText + "</b><html>", SwingConstants.CENTER);
        additionalTextLabel.setBounds(500, 35, 800, 400);
        additionalTextLabel.setFont(new Font("Serif", Font.PLAIN, 30)); // Tipo de letra Arial, tamaño 14         
        
        // Crear texto adicional 2
        JLabel additionalTextLabel2 = new JLabel("<html><b>" + additionalText2 + "</b><html>", SwingConstants.CENTER);
        additionalTextLabel2.setBounds(500, 435, 400, 400);
        additionalTextLabel2.setFont(new Font("Serif", Font.PLAIN, 30)); // Tipo de letra Arial, tamaño 14         
        
             
        //boton regresar 
        JButton backButton = new JButton("Regresar");
        backButton.setBounds(1200, 720, 150, 50); // Posicionar el botón de regresar en la parte inferior derecha
        // Crear los iconos para los botones
ImageIcon iconButton1 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\icono.png");

// Redimensionar los iconos para ajustarlos a los botones
Image iconImage1 = iconButton1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);

// Asignar los iconos redimensionados a los botones
backButton.setIcon(new ImageIcon(iconImage1));

// Posicionar los iconos en el texto
backButton.setHorizontalTextPosition(SwingConstants.RIGHT);
backButton.setVerticalTextPosition(SwingConstants.CENTER);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                messageFrame.dispose(); // Cierra la ventana emergente
            }
        });

        // Agregar componentes a la ventana emergente
        messageFrame.add(titleLabel);
        messageFrame.add(imageLabel);
        messageFrame.add(imageLabel2);
        messageFrame.add(additionalTextLabel);
        messageFrame.add(additionalTextLabel2);
        messageFrame.add(backButton);

        // Añadir la imagen de fondo
    messageFrame.getContentPane().add(backgroundLabel);
        
        messageFrame.setVisible(true);
        
         
     }
 //-----------------------------------------------------------------------------------------------------------------------------------------------   
    
     
     
     
     
     
     
     
     
     
     
     

//----------------------------------------------------BOTON ENTRAR----------------------------------------------------------------------
     // Método para mostrar el menú con los botones "Experto" y "Usuario"
    private static void mostrarMenuUsuarioExperto() {
        JFrame menuFrame = new JFrame("Selecciona tu perfil");
    menuFrame.setSize(600, 400); // Tamaño de la ventana
    menuFrame.setUndecorated(true); 
    menuFrame.setLayout(null); // Usar layout nulo para personalización completa

    // Centrar el frame en la pantalla
    menuFrame.setLocationRelativeTo(null);

    // Cargar la imagen de fondo
    ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\fondo2.jpg"); // Ruta de la imagen de fondo
    Image backgroundImage = backgroundIcon.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH); // Ajustar la imagen al tamaño del JFrame
    JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
    backgroundLabel.setBounds(0, 0, 600, 400); // Ajustar los límites del JLabel al tamaño del JFrame

    // Crear un título en la ventana emergente
    JLabel titleLabel = new JLabel("<html><b>" + "INTERFACES" + "</b></html>", SwingConstants.CENTER);
    titleLabel.setBounds(200, 20, 200, 50); // Ajusta la posición del título
    titleLabel.setFont(new Font("Serif", Font.BOLD, 30)); // Tipo de letra Serif, tamaño 40

    // Crear los botones "Experto" y "Usuario"
    JButton buttonExperto = new JButton("Experto");
    JButton buttonUsuario = new JButton("Usuario");
    JButton backButton = new JButton("Regresar");
    
    // Cargar los iconos de los botones
    ImageIcon iconButton1 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\experto.png");
    ImageIcon iconButton2 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\usuario.png");
    ImageIcon iconButton3 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\icono.png");
    
    // Redimensionar los iconos para ajustarlos a los botones
    Image iconImage1 = iconButton1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    Image iconImage2 = iconButton2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    Image iconImage3 = iconButton3.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    
    // Asignar los iconos redimensionados a los botones
    buttonExperto.setIcon(new ImageIcon(iconImage1));
    buttonUsuario.setIcon(new ImageIcon(iconImage2));
    backButton.setIcon(new ImageIcon(iconImage3));

    // Posicionar los iconos en el texto
    buttonExperto.setHorizontalTextPosition(SwingConstants.RIGHT);
    buttonExperto.setVerticalTextPosition(SwingConstants.CENTER);
    
    buttonUsuario.setHorizontalTextPosition(SwingConstants.RIGHT);
    buttonUsuario.setVerticalTextPosition(SwingConstants.CENTER);
   
    backButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    backButton.setVerticalTextPosition(SwingConstants.CENTER);

    // Posicionar los botones
    buttonExperto.setBounds(230, 120, 150, 50);
    buttonUsuario.setBounds(230, 190, 150, 50);
    backButton.setBounds(430, 300, 150, 50); 

    // Crear un JLayeredPane para manejar las capas
    JLayeredPane layeredPane = new JLayeredPane();
    layeredPane.setBounds(0, 0, 600, 400);

    // Añadir los componentes al JLayeredPane en diferentes capas
    layeredPane.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER); // Fondo en la capa más baja
    layeredPane.add(titleLabel, JLayeredPane.PALETTE_LAYER); // Título en una capa superior
    layeredPane.add(buttonExperto, JLayeredPane.PALETTE_LAYER); // Botones en una capa superior
    layeredPane.add(buttonUsuario, JLayeredPane.PALETTE_LAYER); // Botones en una capa superior
    layeredPane.add(backButton, JLayeredPane.PALETTE_LAYER); // Botones en una capa superior
    
    
    // Añadir el layeredPane al JFrame
    menuFrame.add(layeredPane);

    // Acción para el botón "Experto"
    buttonExperto.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            solicitarContraseña();  // Solicitar contraseña al hacer clic en "Experto"
        }
    });

    // Acción para el botón "Usuario"
 
   buttonUsuario.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Define lo que sucede al seleccionar "Usuario"
            
            // Aquí podrías redirigir a otra ventana si es necesario, por ejemplo:
            mostrarVentanaUsuario();  // Llama a un método para mostrar la ventana de usuario
        }
    });
   
   
   
   backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menuFrame.dispose(); // Cierra la ventana emergente
            }
        });
   

    menuFrame.setVisible(true); // Hacer visible el frame
    }
 //-------------------------------------------------------------------------------------------------------------------------------------------
    
    

    
    
    
    
    
//----------------------------------------------- Método para solicitar la contraseña------------------------------------------------------
private static void solicitarContraseña() {
    boolean contraseñaCorrecta = false;  // Variable para controlar el ciclo

    // Mantener la ventana abierta hasta que la contraseña sea correcta o el usuario presione "Cancelar"
    while (!contraseñaCorrecta) {
        // Crear un campo de contraseña
        JPasswordField passwordField = new JPasswordField(20);

        // Centrar el texto que se escribe en el JPasswordField
        passwordField.setHorizontalAlignment(JTextField.CENTER);

        // Crear un JPanel para centrar el campo de contraseña
        JPanel panel = new JPanel(new BorderLayout());

        JLabel etiqueta = new JLabel("Introduce la contraseña de experto:", JLabel.CENTER); // Centrar la etiqueta
        panel.add(etiqueta, BorderLayout.NORTH);
        panel.add(passwordField, BorderLayout.CENTER);

        // Mostrar el cuadro de diálogo
        int option = JOptionPane.showConfirmDialog(null, panel, "Autenticación", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        // Poner el foco en el campo de contraseña (el cursor estará listo para escribir)
        passwordField.requestFocusInWindow();

        if (option == JOptionPane.OK_OPTION) {
            // Convertir la contraseña ingresada a un String
            String contraseña = new String(passwordField.getPassword());

            // Verificar si la contraseña es correcta
            if (contraseña.equals("123456")) {  // Cambia "1234" por la contraseña que desees
                contraseñaCorrecta = true;  // Salir del ciclo
                mostrarVentanaExperto();  // Mostrar la ventana de experto si la contraseña es correcta
            } else {
                // Mostrar un mensaje de error si la contraseña es incorrecta
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta. Inténtalo de nuevo.");
            }
        } else {
            // Si el usuario presiona "Cancelar", salir del ciclo
            break;
        }
    }
}
//-------------------------------------------------------------------------------------------------------------------------------------------
  



//-------------------------------------- Método para mostrar la ventana de experto-----------------------------
private static void mostrarVentanaExperto() {
    JFrame expertoFrame = new JFrame();
    expertoFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizar la ventana
    expertoFrame.setUndecorated(true); // Sin decoración
    expertoFrame.setLayout(null); // Usamos null layout para control manual de las posiciones
    expertoFrame.setSize(1920, 1080);

    // Crear un panel para el título
    JPanel titlePanel = new JPanel();
    titlePanel.setBounds(250, 0, 1080, 50); // Tamaño del panel del título
    titlePanel.setBackground(Color.GRAY); // Color de fondo del título
    titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrar el texto

    JLabel titleLabel = new JLabel("Menu Experto");
    titleLabel.setForeground(Color.WHITE); // Color del texto
    titleLabel.setFont(new Font("Serif", Font.BOLD, 30)); // Fuente del texto
    titlePanel.add(titleLabel);

    // Cargar la imagen de fondo
    ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\fondo2.jpg");
    Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1920, 1030, Image.SCALE_SMOOTH);
    JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
    backgroundLabel.setBounds(0, 50, 1920, 1030); // Ajustar el tamaño del JLabel al JFrame menos la altura del título

    expertoFrame.add(titlePanel);
    expertoFrame.add(backgroundLabel);

    // Redimensionar las imágenes
    ImageIcon iconImage1 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\objeto.png");
    ImageIcon iconImage2 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\agregar.png");
    ImageIcon iconImage3 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\resolucion.png");

    // Redimensionar imágenes según el tamaño deseado
    Image scaledImage1 = iconImage1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Cambiar el tamaño
    Image scaledImage2 = iconImage2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Cambiar el tamaño
    Image scaledImage3 = iconImage3.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); // Cambiar el tamaño

    JLabel label1 = new JLabel(new ImageIcon(scaledImage1));
    label1.setBounds(630, 300, 50, 50); // Ajustar el tamaño de la primera imagen
    backgroundLabel.add(label1); // Añadir al background

    JLabel label2 = new JLabel(new ImageIcon(scaledImage2));
    label2.setBounds(630, 450, 50, 50); // Ajustar el tamaño de la segunda imagen
    backgroundLabel.add(label2); // Añadir al background

    JLabel label3 = new JLabel(new ImageIcon(scaledImage3));
    label3.setBounds(620, 595, 70, 70); // Ajustar el tamaño de la tercera imagen
    backgroundLabel.add(label3); // Añadir al background

    
    
    
    // ------------------------------------Crear botones con acciones diferentes--------------------------------------------------
    JButton button1 = new JButton("Agregar Enfermedades");
    button1.setBounds(700, 300, 190, 50); // Posicionar el primer botón
    button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           mostrarVentanaObjeto();
        }
    });
    backgroundLabel.add(button1); // Añadir botón al fondo

    
    
    JButton button2 = new JButton("Agregar Sintomas");
    button2.setBounds(700, 450, 150, 50); // Posicionar el segundo botón
    button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaCaracteristicas();
        }
    });
    backgroundLabel.add(button2); // Añadir botón al fondo

    
    
    
    
    JButton button3 = new JButton("Cuadro-Relacion");
    button3.setBounds(700, 600, 150, 50); // Posicionar el tercer botón
    button3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           mostrarVentanaCuadroRelacion();
        }
    });
    backgroundLabel.add(button3); // Añadir botón al fondo

    
    
    
    
    // Botón regresar
    JButton backButton = new JButton("Regresar");
    backButton.setBounds(1200, 720, 150, 50); // Posicionar el botón de regresar en la parte inferior derecha
    ImageIcon iconButton1 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\icono.png");
    Image iconImage = iconButton1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    backButton.setIcon(new ImageIcon(iconImage));
    backButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    backButton.setVerticalTextPosition(SwingConstants.CENTER);
    backButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            expertoFrame.dispose(); // Cierra la ventana emergente
        }
    });
    backgroundLabel.add(backButton); // Añadir botón de regresar al fondo

    expertoFrame.setVisible(true);
}

 //------------------------------------------------------------------------------------------------------------------------------------    
           
 


//-------------------------------------- Método para mostrar la ventana de Usuario-----------------------------
private static void mostrarVentanaUsuario() {
    JFrame expertoFrame = new JFrame();
    expertoFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizar la ventana
    expertoFrame.setUndecorated(true); // Sin decoración
    expertoFrame.setLayout(null); // Usamos null layout para control manual de las posiciones
    expertoFrame.setSize(1920, 1080);

    // Crear un panel para el título
    JPanel titlePanel = new JPanel();
    titlePanel.setBounds(250, 0, 1080, 50); // Tamaño del panel del título
    titlePanel.setBackground(Color.GRAY); // Color de fondo del título
    titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER)); // Centrar el texto

    JLabel titleLabel = new JLabel("Interfaz Usuario");
    titleLabel.setForeground(Color.WHITE); // Color del texto
    titleLabel.setFont(new Font("Serif", Font.BOLD, 30)); // Fuente del texto
    titlePanel.add(titleLabel);

    // Cargar la imagen de fondo
    ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\fondo2.jpg");
    Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1920, 1030, Image.SCALE_SMOOTH);
    JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
    backgroundLabel.setBounds(0, 50, 1920, 1030); // Ajustar el tamaño del JLabel al JFrame menos la altura del título

    expertoFrame.add(titlePanel);
    expertoFrame.add(backgroundLabel);

    // Redimensionar las imágenes
    ImageIcon iconImage1 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\objeto.png");
    ImageIcon iconImage2 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\agregar.png");
    

    // Redimensionar imágenes según el tamaño deseado
    Image scaledImage1 = iconImage1.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Cambiar el tamaño
    Image scaledImage2 = iconImage2.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Cambiar el tamaño
   
    JLabel label1 = new JLabel(new ImageIcon(scaledImage1));
    label1.setBounds(630, 300, 50, 50); // Ajustar el tamaño de la primera imagen
    backgroundLabel.add(label1); // Añadir al background

    JLabel label2 = new JLabel(new ImageIcon(scaledImage2));
    label2.setBounds(630, 450, 50, 50); // Ajustar el tamaño de la segunda imagen
    backgroundLabel.add(label2); // Añadir al background

    
    
    
    // ------------------------------------Crear botones con acciones diferentes--------------------------------------------------
    JButton button1 = new JButton("Busqueda por Sintomas");
    button1.setBounds(700, 300, 190, 50); // Posicionar el primer botón
    button1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
           mostrarVentanaSintomas();
        }
    });
    backgroundLabel.add(button1); // Añadir botón al fondo

    
    
    JButton button2 = new JButton("Busqueda por Enfermedades");
    button2.setBounds(700, 450, 190, 50); // Posicionar el segundo botón
    button2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            mostrarVentanaCaracteristicas();
        }
    });
    backgroundLabel.add(button2); // Añadir botón al fondo

    
    // Botón regresar
    JButton backButton = new JButton("Regresar");
    backButton.setBounds(1200, 720, 150, 50); // Posicionar el botón de regresar en la parte inferior derecha
    ImageIcon iconButton1 = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\icono.png");
    Image iconImage = iconButton1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
    backButton.setIcon(new ImageIcon(iconImage));
    backButton.setHorizontalTextPosition(SwingConstants.RIGHT);
    backButton.setVerticalTextPosition(SwingConstants.CENTER);
    backButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            expertoFrame.dispose(); // Cierra la ventana emergente
        }
    });
    backgroundLabel.add(backButton); // Añadir botón de regresar al fondo

    expertoFrame.setVisible(true);
}
//-------------------------------------------------------------------------------------------------------------------------



//-------------------------------VENTANA SINTOMAS (USUARIO)----------------------------------------------------------------
private static void mostrarVentanaSintomas() {
    // Cargar objetos y síntomas desde la base de datos
    List<Caract> sintomas = cargarCaracteristicasDesdeBaseDeDatos(); // Asegúrate de tener esta función

    // Crear ventana emergente para modificar el registro
    JFrame modificarFrame = new JFrame("");
    modificarFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizar la ventana
    modificarFrame.setUndecorated(true);
    modificarFrame.setLocationRelativeTo(null);

    ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\fondowhite.jpg");
    Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
    JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
    backgroundLabel.setBounds(0, 0, 1920, 1080);


 // Panel para el título
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(250, 0, 1080, 50); 
        titlePanel.setBackground(Color.GRAY); 
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel titleLabel = new JLabel("Busqueda por Sintomas");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30)); 
        titlePanel.add(titleLabel);
        modificarFrame.add(titlePanel);
    
   

    // ComboBox para seleccionar SINTOMAS
    JLabel labelSintoma = new JLabel("SINTOMA:");
    JComboBox<Caract> sintomasRegistros = new JComboBox<>();
    labelSintoma.setBounds(290, 300, 200, 30);
    sintomasRegistros.addItem(null);
    sintomasRegistros.setFont(new Font("Arial", Font.BOLD, 13)); // Fuente personalizada
    sintomasRegistros.setBounds(380, 300, 160, 30);
    modificarFrame.add(sintomasRegistros);
    modificarFrame.add(labelSintoma);

    // Panel con borde para la imagen cargada
    JPanel panelImagenMod = new JPanel();
    panelImagenMod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    panelImagenMod.setLayout(new BorderLayout());
    JLabel imagenCargadaMod = new JLabel();
    imagenCargadaMod.setHorizontalAlignment(JLabel.CENTER);
    imagenCargadaMod.setVerticalAlignment(JLabel.CENTER);
    panelImagenMod.add(imagenCargadaMod);
    panelImagenMod.setBounds(1000, 150, 300, 300);
    modificarFrame.add(panelImagenMod);

   

    // Agregar síntomas al JComboBox de SINTOMAS
    for (Caract sintoma : sintomas) {
        sintomasRegistros.addItem(sintoma);
    }

    // Crear un modelo de tabla
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Síntoma");
    

    // JTable para mostrar los síntomas seleccionados
    JTable tableSintomas = new JTable(tableModel);
    tableSintomas.setBounds(600, 300, 400, 200);
    tableSintomas.setFont(new Font("Arial", Font.BOLD, 13)); // Fuente personalizada
    tableSintomas.setFillsViewportHeight(true);
    JScrollPane scrollPane = new JScrollPane(tableSintomas);
    scrollPane.setBounds(400, 500, 400, 200);
    modificarFrame.add(scrollPane);

    
   // Al seleccionar una enfermedad, cargar los síntomas y sus pesos correspondientes
   List<String> sintomasGuardados = new ArrayList<>();
   List<String> sintomasNuevos = new ArrayList<>();
   List<String> sintomasAgregados = new ArrayList<>();

sintomasRegistros.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Caract objetoSeleccionado = (Caract) sintomasRegistros.getSelectedItem();
        if (objetoSeleccionado != null) {
            imagenCargadaMod.setIcon(objetoSeleccionado.imagen_sintoma);

            
            // Limpiar las listas de síntomas
            sintomasGuardados.clear();
            sintomasNuevos.clear();

      // Cargar todos los síntomas disponibles
try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/objeto", "root", "S1lw0lf.2002")) {
    PreparedStatement stmt = connection.prepareStatement(
        "SELECT nombre_sintoma FROM sintomas" // Seleccionar solo los nombres de los síntomas
    );

    ResultSet rs = stmt.executeQuery();

    // Añadir solo los nombres de los síntomas a la lista
    while (rs.next()) {
        String sintomaNombre = rs.getString("nombre_sintoma");
        sintomasGuardados.add(sintomaNombre); // Agregar a la lista de síntomas guardados
    }
} catch (SQLException ex) {
    ex.printStackTrace();
    JOptionPane.showMessageDialog(modificarFrame, "Error al cargar los síntomas: " + ex.getMessage());
}

        }
    }
});




// Botón Añadir
JButton añadirButton = new JButton("");
añadirButton.setBounds(550, 380, 80, 70);
ImageIcon iconoAñadir = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\added.png");
añadirButton.setIcon(iconoAñadir);
Image imgAdd = iconoAñadir.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 40, 40 por el tamaño que necesites
añadirButton.setIcon(new ImageIcon(imgAdd));

// Estilos del botón

añadirButton.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
añadirButton.setForeground(Color.WHITE); // Color de texto
añadirButton.setBorderPainted(false); // Ocultar el borde
añadirButton.setFocusPainted(false); // Quitar el borde de enfoque
añadirButton.setOpaque(false); // Asegurarte de que el fondo se muestre
añadirButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

// Botón Añadir
añadirButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Caract sintomaSeleccionado = (Caract) sintomasRegistros.getSelectedItem();

        // Verificar si hay un síntoma seleccionado
        if (sintomaSeleccionado == null) {
            JOptionPane.showMessageDialog(modificarFrame, "Por favor, selecciona un síntoma para añadir.");
            return;
        }

        // Verificar si el síntoma ya está en el JTable
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String sintomaExistente = (String) tableModel.getValueAt(i, 0);
            if (sintomaExistente.equals(sintomaSeleccionado.nombre_sintoma)) {
                JOptionPane.showMessageDialog(modificarFrame, "El síntoma '" + sintomaSeleccionado.nombre_sintoma + "' ya ha sido agregado.");
                return; // Salir si ya existe en el JTable
            }
        }

        // Verificar si el síntoma ya está en la base de datos
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/objeto", "root", "S1lw0lf.2002")) {
            // Paso 1: Obtener el ID del síntoma en la tabla 'sintomas'
            PreparedStatement stmtObtenerId = connection.prepareStatement(
                "SELECT id FROM sintomas WHERE nombre_sintoma = ?");
            stmtObtenerId.setString(1, sintomaSeleccionado.nombre_sintoma);
            ResultSet rsId = stmtObtenerId.executeQuery();

            if (rsId.next()) {
                int sintomaId = rsId.getInt("id");

                // Paso 2: Verificar si ese ID ya existe en la tabla 'relacion'
                PreparedStatement stmtVerificar = connection.prepareStatement(
                    "SELECT 1 FROM sintomas WHERE nombre_sintoma= ?");
                stmtVerificar.setInt(1, sintomaId);
                ResultSet rsVerificar = stmtVerificar.executeQuery();

                if (rsVerificar.next()) {
                    JOptionPane.showMessageDialog(modificarFrame, "El síntoma '" + sintomaSeleccionado.nombre_sintoma + "' ya está registrado en la base de datos.");
                    return; // Salir si ya existe en la base de datos
                }
            } else {
                JOptionPane.showMessageDialog(modificarFrame, "El síntoma seleccionado no existe en la base de datos.");
                return;
            }

            // Agregar el síntoma al JTable
            tableModel.addRow(new Object[]{sintomaSeleccionado.nombre_sintoma});
            sintomasNuevos.add(sintomaSeleccionado.nombre_sintoma); // Agregar a la lista de síntomas nuevos

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(modificarFrame, "Error al verificar el síntoma en la base de datos: " + ex.getMessage());
        }
    }
});

modificarFrame.add(añadirButton);







// Botón Borrar
JButton borrarButton = new JButton("");
borrarButton.setBounds(830, 600, 60, 70); // Posicionar el botón de borrar
ImageIcon iconoBorrar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\delete.png");
borrarButton.setIcon(iconoBorrar);
Image imgB = iconoBorrar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 40, 40 por el tamaño que necesites
borrarButton.setIcon(new ImageIcon(imgB));

// Estilos del botón

borrarButton.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
borrarButton.setForeground(Color.WHITE); // Color de texto
borrarButton.setBorderPainted(false); // Ocultar el borde
borrarButton.setFocusPainted(false); // Quitar el borde de enfoque
borrarButton.setOpaque(false); // Asegurarte de que el fondo se muestre
borrarButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

// Establecer una fuente
borrarButton.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente personalizada


borrarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        int selectedRow = tableSintomas.getSelectedRow();
        if (selectedRow != -1) {
            String sintomaNombre = (String) tableModel.getValueAt(selectedRow, 0);

            // Eliminar el síntoma de la tabla y las listas asociadas
            tableModel.removeRow(selectedRow);
            sintomasAgregados.remove(sintomaNombre);
            sintomasNuevos.remove(sintomaNombre); // Remover si está en la lista de nuevos
            tableSintomas.repaint(); // Forzar refresco visual
        } else {
            JOptionPane.showMessageDialog(modificarFrame, "Por favor, selecciona un síntoma para borrar.");
        }
    }
});

modificarFrame.add(borrarButton);

 
  // Botón Cancelar
JButton cancelarButton = new JButton("");
cancelarButton.setBounds(650, 730, 80, 60);
ImageIcon iconoCancelar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\cancel.png");
cancelarButton.setIcon(iconoCancelar);
Image imgCan = iconoCancelar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 40, 40 por el tamaño que necesites
cancelarButton.setIcon(new ImageIcon(imgCan));

// Estilos del botón

cancelarButton.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
cancelarButton.setForeground(Color.WHITE); // Color de texto
cancelarButton.setBorderPainted(false); // Ocultar el borde
cancelarButton.setFocusPainted(false); // Quitar el borde de enfoque
cancelarButton.setOpaque(false); // Asegurarte de que el fondo se muestre
cancelarButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

// Establecer una fuente
cancelarButton.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente personalizada

cancelarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Crear botones personalizados
        Object[] opciones = {"Sí", "No"};

        // Mostrar cuadro de diálogo de confirmación
        int respuesta = JOptionPane.showOptionDialog(modificarFrame,
                "¿Estás seguro de que deseas cancelar?",
                "Confirmar cancelación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                opciones,
                opciones[1]); // predeterminado a "No"

        // Si el usuario selecciona "Sí", limpiar el JTable y otros campos de entrada
        if (respuesta == 0) { // 0 es el índice de "Sí"
            tableModel.setRowCount(0); // Limpiar los síntomas y pesos de la tabla
            
            // Limpiar los campos: ComboBox, JTextField y tabla
            sintomasRegistros.setSelectedIndex(-1);
            
            imagenCargadaMod.setIcon(null); // Esto eliminará la imagen actual del JLabel
            
            
        }
    }
});
modificarFrame.add(cancelarButton);

// Botón Salir
JButton botonSalir = new JButton("");
botonSalir.setBounds(1300, 750, 80, 60);
ImageIcon iconoSalir = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\exit.png");
botonSalir.setIcon(iconoSalir);
Image img = iconoSalir.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonSalir.setIcon(new ImageIcon(img));
// Estilos del botón

botonSalir.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonSalir.setForeground(Color.WHITE); // Color de texto
botonSalir.setBorderPainted(false); // Ocultar el borde
botonSalir.setFocusPainted(false); // Quitar el borde de enfoque
botonSalir.setOpaque(false); // Asegurarte de que el fondo se muestre
botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonSalir.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Crear botones personalizados
        Object[] opciones = {"Sí", "No"};
        
        // Mostrar cuadro de diálogo de confirmación
        int respuesta = JOptionPane.showOptionDialog(modificarFrame,
                "¿Estás seguro de que quieres salir?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                opciones,
                opciones[1]); // predeterminado a "No"

        // Si el usuario selecciona "Sí", cerrar la ventana
        if (respuesta == 0) { // 0 es el índice de "Sí"
            modificarFrame.dispose(); // Cerrar la ventana
        }
    }
});

modificarFrame.add(botonSalir);


    // Configuración final de la ventana
    modificarFrame.add(backgroundLabel);
    modificarFrame.setLayout(null);
    modificarFrame.setVisible(true);
}
//--------------------------------------------------------------------------------------------------------------------------------------------
 



























































































//-------------------------------------- Método para mostrar la ventana de Enfermedades-----------------------------
 private static void mostrarVentanaObjeto() {
        JFrame expertoFrame = new JFrame();
        expertoFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizar la ventana
        expertoFrame.setUndecorated(true); 
        expertoFrame.setLayout(null); 

        
    ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\azul.jpg");
    Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1920, 1030, Image.SCALE_SMOOTH);
    JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
    backgroundLabel.setBounds(0, 0, 1920, 1030); // Ajustar el tamaño del JLabel al JFrame menos la altura del título

        
        // Panel para el título
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(250, 0, 1080, 50); 
        titlePanel.setBackground(Color.GRAY); 
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel titleLabel = new JLabel("Datos Enfermedades");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30)); 
        titlePanel.add(titleLabel);
        expertoFrame.add(titlePanel);

        // Cuadro de texto para el nombre del objeto
        JLabel labelObjeto = new JLabel("NOMBRE ENFERMEDAD:");
        labelObjeto.setBounds(220, 170, 200, 30);//labelDescripcion.setBounds(270, 300, 200, 30); scrollDescripcion.setBounds(380, 240, 300, 200);
        JTextField textoObjeto = new JTextField();
        // Cambiar el color de fondo del ComboBox
textoObjeto.setBackground(Color.WHITE); // Cambia LIGHT_GRAY por el color que desees

         textoObjeto.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente personalizada
        textoObjeto.setBounds(380, 170, 260, 30);
        expertoFrame.add(labelObjeto);
        expertoFrame.add(textoObjeto);

        // Cuadro de texto para la descripción
JLabel labelDescripcion = new JLabel("DESCRIPCIÓN:");
labelDescripcion.setBounds(270, 300, 200, 30);
JTextArea textoDescripcion = new JTextArea();
 textoDescripcion.setFont(new Font("Arial", Font.BOLD, 12)); // Fuente personalizada
textoDescripcion.setLineWrap(true); 
textoDescripcion.setWrapStyleWord(true);
JScrollPane scrollDescripcion = new JScrollPane(textoDescripcion);
scrollDescripcion.setBounds(380, 240, 300, 200);
expertoFrame.add(labelDescripcion);
expertoFrame.add(scrollDescripcion);


  
        // Panel con borde para la imagen cargada
        JPanel panelImagen = new JPanel();
        panelImagen.setBounds(1000, 150, 300, 300);
        panelImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        panelImagen.setLayout(new BorderLayout());
        JLabel imagenCargada = new JLabel(); 
        imagenCargada.setHorizontalAlignment(JLabel.CENTER);
        imagenCargada.setVerticalAlignment(JLabel.CENTER);
        panelImagen.add(imagenCargada); 
        expertoFrame.add(panelImagen); 

      // Botón para cargar imagen
JButton botonImagen = new JButton("");
botonImagen.setBounds(1120, 470, 50, 50);
ImageIcon iconoImg = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\addimage.png");
botonImagen.setIcon(iconoImg);
Image imgAI = iconoImg.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonImagen.setIcon(new ImageIcon(imgAI));

botonImagen.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonImagen.setForeground(Color.WHITE); // Color de texto
botonImagen.setBorderPainted(false); // Ocultar el borde
botonImagen.setFocusPainted(false); // Quitar el borde de enfoque
botonImagen.setOpaque(false); // Asegurarte de que el fondo se muestre
botonImagen.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonImagen.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        
        // Establecer la ruta inicial donde se abrirá el JFileChooser
        fileChooser.setCurrentDirectory(new File("C:\\Users\\bambi\\OneDrive\\Documents\\Enfermedades"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
            Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imagenCargada.setIcon(new ImageIcon(img));
        }
    }
});
expertoFrame.add(botonImagen);

        
        
        
       // Botón Alta
JButton botonAlta = new JButton("");
ImageIcon iconoAlta = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\added.png"); 
botonAlta.setIcon(iconoAlta);
Image imgA = iconoAlta.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonAlta.setIcon(new ImageIcon(imgA));

botonAlta.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonAlta.setForeground(Color.WHITE); // Color de texto
botonAlta.setBorderPainted(false); // Ocultar el borde
botonAlta.setFocusPainted(false); // Quitar el borde de enfoque
botonAlta.setOpaque(false); // Asegurarte de que el fondo se muestre
botonAlta.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonAlta.setBounds(250, 650, 80, 60);
botonAlta.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Almacenar el nuevo objeto
        String nombre = textoObjeto.getText();
        String descripcion = textoDescripcion.getText();
        ImageIcon imagen = (ImageIcon) imagenCargada.getIcon();

        if (!nombre.isEmpty() && imagen != null) {
            // Convertir la imagen a un arreglo de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                Image img = imagen.getImage();
                BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics g = bufferedImage.createGraphics();
                g.drawImage(img, 0, 0, null);
                g.dispose();
                ImageIO.write(bufferedImage, "png", baos);
                byte[] imagenBytes = baos.toByteArray();

                // Guardar en la base de datos
                String url = "jdbc:mysql://localhost:3306/objeto"; 
                String user = "root"; 
                String password = "S1lw0lf.2002"; 
                
                try (java.sql.Connection conn = DriverManager.getConnection(url, user, password)) {
                    // Verificar si el nombre ya existe (ignorando mayúsculas/minúsculas)
                    String checkSql = "SELECT COUNT(*) FROM objetos WHERE LOWER(nombre) = LOWER(?)";
                    try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                        checkStmt.setString(1, nombre);
                        ResultSet rs = checkStmt.executeQuery();
                        if (rs.next() && rs.getInt(1) > 0) {
                            JOptionPane.showMessageDialog(null, "El nombre ya existe. No se puede duplicar.");
                        } else {
                            // Si no existe, insertar el nuevo registro
                            String sql = "INSERT INTO objetos (nombre, descripcion, imagen) VALUES (?, ?, ?)";
                            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                                pstmt.setString(1, nombre);
                                pstmt.setString(2, descripcion);
                                pstmt.setBytes(3, imagenBytes);
                                pstmt.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Registro agregado correctamente.");
                                
                                // Limpiar los campos después de agregar
                                textoObjeto.setText(""); 
                                textoDescripcion.setText(""); 
                                imagenCargada.setIcon(null); 
                            }
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al procesar la imagen: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre, la descripción y cargar una imagen.");
        }
    }
});
expertoFrame.add(botonAlta);

        
        
      

// Botón Baja
JButton botonBaja = new JButton("");
botonBaja.setBounds(390, 650, 80, 60);
ImageIcon iconoBaja = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\delete.png"); 
botonBaja.setIcon(iconoBaja);
Image imgB = iconoBaja.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonBaja.setIcon(new ImageIcon(imgB));

botonBaja.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonBaja.setForeground(Color.WHITE); // Color de texto
botonBaja.setBorderPainted(false); // Ocultar el borde
botonBaja.setFocusPainted(false); // Quitar el borde de enfoque
botonBaja.setOpaque(false); // Asegurarte de que el fondo se muestre
botonBaja.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón
botonBaja.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Conectar a la base de datos y verificar si hay registros
        String url = "jdbc:mysql://localhost:3306/objeto"; // Cambia "tu_base_de_datos" por el nombre real
        String user = "root"; // Cambia "usuario" por el nombre de usuario correcto
        String password = "S1lw0lf.2002"; // Cambia "contraseña" por la contraseña correcta
        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT COUNT(*) FROM objetos"; // Consulta para contar el número de registros
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // Si hay registros, abrir la ventana emergente para eliminar
                JFrame bajaFrame = new JFrame("Eliminar Registro");
                bajaFrame.setSize(400, 100);
                bajaFrame.setLayout(new FlowLayout());
                bajaFrame.setLocationRelativeTo(null);
                
                JComboBox<String> comboRegistros = new JComboBox<>();
                
                // Llenar el combo con los nombres de los objetos
                String sqlRegistros = "SELECT nombre FROM objetos";
                PreparedStatement pstmtRegistros = conn.prepareStatement(sqlRegistros);
                ResultSet rsRegistros = pstmtRegistros.executeQuery();
                while (rsRegistros.next()) {
                    comboRegistros.addItem(rsRegistros.getString("nombre"));
                }

                bajaFrame.add(comboRegistros);
                
                JButton confirmarEliminar = new JButton("Eliminar");
                confirmarEliminar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nombreSeleccionado = (String) comboRegistros.getSelectedItem();
                        
                        // Conectar a la base de datos y eliminar el registro seleccionado
                        try (Connection conn = DriverManager.getConnection(url, user, password)) {
                            String sql = "DELETE FROM objetos WHERE nombre = ?";
                            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                                pstmt.setString(1, nombreSeleccionado);
                                int filasAfectadas = pstmt.executeUpdate();
                                if (filasAfectadas > 0) {
                                    JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
                                    
                                    // Limpiar la selección y el combo
                                    comboRegistros.removeItem(nombreSeleccionado); // Remover el elemento eliminado del combo
                                    if (comboRegistros.getItemCount() > 0) {
                                        comboRegistros.setSelectedIndex(0); // Seleccionar el primer elemento si queda
                                    } else {
                                        comboRegistros.setSelectedIndex(-1); // Si no queda ninguno, reiniciar selección
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se encontró el registro a eliminar.");
                                }
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                        bajaFrame.dispose(); // Cerrar la ventana de baja
                    }
                });
                bajaFrame.add(confirmarEliminar);
                
                bajaFrame.setVisible(true);
            } else {
                // Si no hay registros, mostrar un mensaje y no hacer nada
                JOptionPane.showMessageDialog(null, "No hay registros en la base de datos para eliminar.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
});
expertoFrame.add(botonBaja);





        
        
// Botón Consultar
JButton botonConsultar = new JButton("");
ImageIcon iconoConsultar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\search.png");
botonConsultar.setIcon(iconoConsultar);
Image imgCon = iconoConsultar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonConsultar.setIcon(new ImageIcon(imgCon));


botonConsultar.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonConsultar.setForeground(Color.WHITE); // Color de texto
botonConsultar.setBorderPainted(false); // Ocultar el borde
botonConsultar.setFocusPainted(false); // Quitar el borde de enfoque
botonConsultar.setOpaque(false); // Asegurarte de que el fondo se muestre
botonConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonConsultar.setBounds(530, 650, 80, 60);


botonConsultar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Conectar a la base de datos y verificar si hay registros
        String url = "jdbc:mysql://localhost:3306/objeto"; 
        String user = "root"; 
        String password = "S1lw0lf.2002"; 
        
        boolean hayRegistros = false; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT COUNT(*) AS total FROM objetos"; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hayRegistros = rs.getInt("total") > 0; 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + ex.getMessage());
            ex.printStackTrace();
        }

        // Si no hay registros
        if (!hayRegistros) {
            JOptionPane.showMessageDialog(null, "No existen registros en la base de datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; 
        }

        // Si hay registros, mostrar opciones
        String[] opciones = {"Particular", "General"};
        int seleccion = JOptionPane.showOptionDialog(null, "¿Qué tipo de consulta deseas hacer?", "Seleccionar consulta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == 0) { // Particular
            List<String> nombresRegistros = new ArrayList<>();

            // Cargar los nombres de los objetos
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String sql = "SELECT nombre FROM objetos";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    nombresRegistros.add(rs.getString("nombre"));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al consultar registros: " + ex.getMessage());
                ex.printStackTrace();
            }

            // Mostrar un JComboBox con los nombres
            JComboBox<String> comboParticular = new JComboBox<>(nombresRegistros.toArray(new String[0]));
            int respuesta = JOptionPane.showConfirmDialog(null, comboParticular, "Selecciona un registro", JOptionPane.OK_CANCEL_OPTION);

            if (respuesta == JOptionPane.OK_OPTION) {
                String nombreSeleccionado = (String) comboParticular.getSelectedItem();
                // Limpiar los campos
        //textoObjeto.setText(""); // Limpiar el campo de texto del nombre
        //textoDescripcion.setText(""); // Limpiar el área de texto de la descripción
        //imagenCargada.setIcon(null); // Limpiar el JLabel de la imagen

                if (nombreSeleccionado != null) {
                    try (Connection conn = DriverManager.getConnection(url, user, password)) {
                        String sql = "SELECT nombre, descripcion, imagen FROM objetos WHERE nombre=?";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, nombreSeleccionado);
                        ResultSet rs = pstmt.executeQuery();

                        if (rs.next()) {
                            String nombre = rs.getString("nombre");
                            String descripcion = rs.getString("descripcion");

                            // Imagen como BLOB
                            byte[] imagenBytes = rs.getBytes("imagen");
                            ImageIcon icon = null;

                            if (imagenBytes != null) {
                                // Convertir a ImageIcon y escalar
                                icon = new ImageIcon(imagenBytes);
                                Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                                icon = new ImageIcon(img);
                            }

                            // Mostrar nombre y descripción con scroll en descripción
                            JTextArea descripcionArea = new JTextArea(descripcion);
                            descripcionArea.setWrapStyleWord(true);
                            descripcionArea.setLineWrap(true);
                            descripcionArea.setEditable(false);
                            descripcionArea.setFont(new Font("Arial", Font.BOLD, 12)); // Fuente personalizada
                            JScrollPane scrollPaneDesc = new JScrollPane(descripcionArea);
                            scrollPaneDesc.setPreferredSize(new Dimension(300, 150));

                            JPanel panelDetalles = new JPanel();
                            panelDetalles.setLayout(new BorderLayout());
                            panelDetalles.add(new JLabel(nombre), BorderLayout.NORTH);
                            panelDetalles.add(scrollPaneDesc, BorderLayout.CENTER);

                            JOptionPane.showMessageDialog(null, panelDetalles, "Detalle del Registro", JOptionPane.INFORMATION_MESSAGE, icon);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al obtener detalles del registro: " + ex.getMessage());
                    }
                }
            }
        } else if (seleccion == 1) { // General
            // Mostrar la tabla con los registros
            String[] columnNames = {"Nombre", "Descripción", "Imagen"};
            List<Object[]> dataList = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String sql = "SELECT nombre, descripcion, imagen FROM objetos"; 
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String nombre = rs.getString("nombre");
                    String descripcion = rs.getString("descripcion");
                    byte[] imagenBytes = rs.getBytes("imagen");
                    ImageIcon icon = null;

                    if (imagenBytes != null) {
                        icon = new ImageIcon(imagenBytes);
                        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        icon = new ImageIcon(img);
                    }

                   // Usar HTML para mostrar la descripción larga con ajuste de línea
String descripcionConFormato = "<html><body style='width: 290px; margin-top: 10px;'>" +
    "<div style='text-align: center;'>" +
        "<p style='text-align: justify;'>" + descripcion + "</p>" +
    "</div>" +
"</body></html>";



                    
                    // Usar HTML para mostrar el nombre con ajuste de línea
                    String nombreConFormato = "<html><body style='width: 115px;text-align: center; margin-top: 10px;'>" +
                               nombre + "</body></html>";

                    dataList.add(new Object[]{nombreConFormato, descripcionConFormato, icon});
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al consultar registros: " + ex.getMessage());
                ex.printStackTrace();
            }

            // Crear tabla
            Object[][] data = new Object[dataList.size()][3];
            for (int i = 0; i < dataList.size(); i++) {
                data[i] = dataList.get(i);
            }

            JTable table = new JTable(data, columnNames) {
                @Override
                public Class<?> getColumnClass(int column) {
                    return column == 2 ? ImageIcon.class : Object.class;
                }
            };

            table.getColumnModel().getColumn(0).setPreferredWidth(70); // Nombre
            table.getColumnModel().getColumn(1).setPreferredWidth(300); // Descripción
            table.getColumnModel().getColumn(2).setPreferredWidth(150); // Imagen
            table.setRowHeight(200);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(800, 600));

            // Mostrar el JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Registros Almacenados", JOptionPane.PLAIN_MESSAGE);
        }
    }
});

expertoFrame.add(botonConsultar);



        
        
// Botón Modificación
JButton botonModificar = new JButton("");
botonModificar.setBounds(690, 650, 70, 60);
ImageIcon iconoModificar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\edit.png");
botonModificar.setIcon(iconoModificar);
Image imgM = iconoModificar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
botonModificar.setIcon(new ImageIcon(imgM));

botonModificar.setBackground(new Color(100, 149, 237)); // Color de fondo
botonModificar.setForeground(Color.WHITE); // Color de texto
botonModificar.setBorderPainted(false); // Ocultar el borde
botonModificar.setFocusPainted(false); // Quitar el borde de enfoque
botonModificar.setOpaque(false); // Fondo visible
botonModificar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonModificar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Cargar objetos desde la base de datos
        List<Objeto> objetos = cargarObjetosDesdeBaseDeDatos();

        if (objetos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay registros disponibles para modificar.");
            return;
        }

        // Crear ventana emergente para modificar el registro
        JFrame modificarFrame = new JFrame("Modificar Registro");
        modificarFrame.setSize(800, 500);
        modificarFrame.setUndecorated(true);
        modificarFrame.setLocationRelativeTo(null);

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\fondo12.jpg");
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 800, 500);

        // ComboBox para seleccionar el objeto a modificar
        JComboBox<String> comboRegistros = new JComboBox<>();
        comboRegistros.addItem(""); // Elemento vacío
        comboRegistros.setBounds(50, 30, 300, 30);
        comboRegistros.setBackground(Color.BLACK); // Fondo negro
        comboRegistros.setForeground(Color.WHITE); // Texto blanco

        modificarFrame.add(comboRegistros);

        // Etiqueta y campo de texto para el nuevo nombre
        JLabel labelNombreMod = new JLabel("Nuevo Nombre:");
        labelNombreMod.setBounds(50, 70, 100, 30);
        labelNombreMod.setForeground(Color.BLACK);
        modificarFrame.add(labelNombreMod);

        JTextField textoNombreMod = new JTextField(20);
        textoNombreMod.setBounds(150, 70, 200, 30);
        modificarFrame.add(textoNombreMod);

        // Etiqueta y área de texto para la descripción
        JLabel labelDescripcionMod = new JLabel("Descripción:");
        labelDescripcionMod.setBounds(50, 200, 100, 30);
        labelDescripcionMod.setForeground(Color.BLACK);
        modificarFrame.add(labelDescripcionMod);

        JTextArea textoDescripcionMod = new JTextArea(5, 20);
        textoDescripcionMod.setLineWrap(true);
        textoDescripcionMod.setWrapStyleWord(true);
        JScrollPane scrollDescripcionMod = new JScrollPane(textoDescripcionMod);
        scrollDescripcionMod.setBounds(150, 128, 200, 200);
        modificarFrame.add(scrollDescripcionMod);

        // Panel para la imagen
        JPanel panelImagenMod = new JPanel();
        panelImagenMod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelImagenMod.setLayout(new BorderLayout());
        JLabel imagenCargadaMod = new JLabel();
        imagenCargadaMod.setHorizontalAlignment(JLabel.CENTER);
        imagenCargadaMod.setVerticalAlignment(JLabel.CENTER);
        panelImagenMod.add(imagenCargadaMod);
        panelImagenMod.setBounds(400, 30, 300, 300);
        modificarFrame.add(panelImagenMod);

        // Botón para cargar nueva imagen
        JButton botonImagenMod = new JButton("");
        botonImagenMod.setBounds(520, 340, 60, 50);
        ImageIcon iconoModificarFrame = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\addimage.png");
        Image imgMF = iconoModificarFrame.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        botonImagenMod.setIcon(new ImageIcon(imgMF));

        botonImagenMod.setBackground(new Color(100, 149, 237)); // Fondo azul
        botonImagenMod.setForeground(Color.WHITE); // Texto blanco
        botonImagenMod.setBorderPainted(false); // Sin borde
        botonImagenMod.setFocusPainted(false); // Sin borde de enfoque
        botonImagenMod.setOpaque(false); // Fondo visible
        botonImagenMod.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cursor de mano

        botonImagenMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("C:\\Users\\bambi\\OneDrive\\Documents\\Enfermedades"));
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    imagenCargadaMod.setIcon(new ImageIcon(img));
                }
            }
        });
        modificarFrame.add(botonImagenMod);

        // Agregar objetos al JComboBox
        for (Objeto obj : objetos) {
            comboRegistros.addItem(obj.nombre);
        }

        // Cargar datos del registro seleccionado en el JComboBox
        comboRegistros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) comboRegistros.getSelectedItem();
                if (nombreSeleccionado.isEmpty()) {
                    return; // No hacer nada si está vacío
                }

                // Mostrar el nombre seleccionado en el JTextField
                textoNombreMod.setText(nombreSeleccionado);

                // Buscar el objeto seleccionado
                Objeto objetoSeleccionado = objetos.stream()
                    .filter(obj -> obj.nombre.equals(nombreSeleccionado))
                    .findFirst().orElse(null);

                if (objetoSeleccionado != null) {
                    textoDescripcionMod.setText(objetoSeleccionado.descripcion);
                    imagenCargadaMod.setIcon(objetoSeleccionado.imagen);
                }
            }
        });

        // Botón para confirmar la modificación
        JButton confirmarModificar = new JButton("");
        confirmarModificar.setBounds(310, 420, 140, 50);
        
        ImageIcon iconoBM = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\editbutton.png");
        confirmarModificar.setIcon(iconoBM);
Image imgBM = iconoBM.getImage().getScaledInstance(320, 140, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
confirmarModificar.setIcon(new ImageIcon(imgBM));

confirmarModificar.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
confirmarModificar.setForeground(Color.WHITE); // Color de texto
confirmarModificar.setBorderPainted(false); // Ocultar el borde
confirmarModificar.setFocusPainted(false); // Quitar el borde de enfoque
confirmarModificar.setOpaque(false); // Asegurarte de que el fondo se muestre
confirmarModificar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón
        confirmarModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) comboRegistros.getSelectedItem();
                Objeto objetoAModificar = objetos.stream()
                    .filter(obj -> obj.nombre.equals(nombreSeleccionado))
                    .findFirst().orElse(null);
                
                // Validar que los campos no estén vacíos y que se haya cargado una imagen
                String nuevoNombre = textoNombreMod.getText().trim();
                String nuevaDescripcion = textoDescripcionMod.getText().trim();
                ImageIcon nuevaImagen = (ImageIcon) imagenCargadaMod.getIcon();
                
                if (nuevoNombre.isEmpty() || nuevaDescripcion.isEmpty() || nuevaImagen == null) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los campos (Nombre, Descripción y cargar una imagen).");
                    return;
                }

                if (objetoAModificar != null) {
                    objetoAModificar.nombre = nuevoNombre;
                    objetoAModificar.descripcion = nuevaDescripcion;
                    objetoAModificar.imagen = nuevaImagen;

                    // Actualizar en la base de datos
                    String url = "jdbc:mysql://localhost:3306/objeto"; // Cambia por tu nombre real de base de datos
                    String user = "root"; // Cambia por el nombre de usuario correcto
                    String password = "S1lw0lf.2002"; // Cambia por la contraseña correcta

                    try (Connection conn = DriverManager.getConnection(url, user, password)) {
                        String sql = "UPDATE objetos SET nombre=?, descripcion=?, imagen=? WHERE nombre=?";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, nuevoNombre);
                        pstmt.setString(2, nuevaDescripcion);

                        // Convertir la imagen a bytes
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        Image img = nuevaImagen.getImage();
                        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                        Graphics g = bufferedImage.createGraphics();
                        g.drawImage(img, 0, 0, null);
                        g.dispose();
                        ImageIO.write(bufferedImage, "jpg", baos);
                        pstmt.setBytes(3, baos.toByteArray());

                        pstmt.setString(4, nombreSeleccionado);
                        pstmt.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente.");
                        modificarFrame.dispose(); // Cerrar ventana de modificación
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al modificar el registro en la base de datos: " + ex.getMessage());
                        ex.printStackTrace();
                    } catch (IOException ioEx) {
                        JOptionPane.showMessageDialog(null, "Error al convertir la imagen: " + ioEx.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el registro.");
                }
            }
        });

        JButton botonSalir = new JButton("");
        botonSalir.setBounds(750, 420, 40, 40);
       ImageIcon iconoSalir = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\exit.png");
        botonSalir.setIcon(iconoSalir);
Image img = iconoSalir.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonSalir.setIcon(new ImageIcon(img));

botonSalir.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonSalir.setForeground(Color.WHITE); // Color de texto
botonSalir.setBorderPainted(false); // Ocultar el borde
botonSalir.setFocusPainted(false); // Quitar el borde de enfoque
botonSalir.setOpaque(false); // Asegurarte de que el fondo se muestre
botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarFrame.dispose(); // Cerrar la ventana
            }
        });

        modificarFrame.add(botonSalir);
        modificarFrame.add(confirmarModificar);
        modificarFrame.add(backgroundLabel);
        modificarFrame.setLayout(null);
        modificarFrame.setVisible(true);
    }
});

expertoFrame.add(botonModificar);



// Botón Inicio
JButton botonInicio = new JButton("");
ImageIcon iconoInicio = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\home.png"); 
botonInicio.setIcon(iconoInicio);
Image imgInicio = iconoInicio.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
botonInicio.setIcon(new ImageIcon(imgInicio));
botonInicio.setBounds(350, 470,70, 50); // Ajusta la posición según sea necesario


botonInicio.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonInicio.setForeground(Color.WHITE); // Color de texto
botonInicio.setBorderPainted(false); // Ocultar el borde
botonInicio.setFocusPainted(false); // Quitar el borde de enfoque
botonInicio.setOpaque(false); // Asegurarte de que el fondo se muestre
botonInicio.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonInicio.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Conectar a la base de datos y obtener el primer registro
        String url = "jdbc:mysql://localhost:3306/objeto"; // Cambia "tu_base_de_datos" por el nombre real
        String user = "root"; // Cambia "usuario" por el nombre de usuario correcto
        String password = "S1lw0lf.2002"; // Cambia "contraseña" por la contraseña correcta

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT nombre, descripcion, imagen FROM objetos LIMIT 1"; // Solo obtén el primer registro
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                byte[] imagenBytes = rs.getBytes("imagen");
                ImageIcon icon = null;

                if (imagenBytes != null) {
                    icon = new ImageIcon(imagenBytes);
                }

                // Mostrar los datos en los componentes correspondientes
                textoObjeto.setText(nombre);
                textoDescripcion.setText(descripcion);
                imagenCargada.setIcon(icon);

                // Hacer visibles los campos solo para visualizar
                textoObjeto.setEnabled(true); 
                textoDescripcion.setEnabled(true); 
                imagenCargada.setEnabled(true);

                // Desactivar inicialmente los campos para evitar edición
                textoObjeto.setEditable(false); 
                textoDescripcion.setEditable(false); 

                // Reiniciar el índice actual
                indiceActual = 0; // Reiniciar el índice
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron registros.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el registro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
});

// Agregar el botón a la ventana
expertoFrame.add(botonInicio);





// Botón Adelante
        JButton botonAdelante = new JButton("");
        ImageIcon iconoAdelante = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\right.png");
        botonAdelante.setIcon(iconoAdelante);
        Image imgAdelante = iconoAdelante.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        botonAdelante.setIcon(new ImageIcon(imgAdelante));
        botonAdelante.setBounds(550, 470, 70, 50); // Ajusta la posición según sea necesario

        
botonAdelante.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonAdelante.setForeground(Color.WHITE); // Color de texto
botonAdelante.setBorderPainted(false); // Ocultar el borde
botonAdelante.setFocusPainted(false); // Quitar el borde de enfoque
botonAdelante.setOpaque(false); // Asegurarte de que el fondo se muestre
botonAdelante.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

        botonAdelante.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (indiceActual == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, presione el botón Inicio primero.");
            return;
        }

        // Conectar a la base de datos y obtener el siguiente registro
        String url = "jdbc:mysql://localhost:3306/objeto"; 
        String user = "root"; 
        String password = "S1lw0lf.2002"; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            indiceActual++; // Incrementar el índice

            String sql = "SELECT nombre, descripcion, imagen FROM objetos LIMIT 1 OFFSET ?"; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, indiceActual); // Establecer el OFFSET

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                byte[] imagenBytes = rs.getBytes("imagen");
                ImageIcon icon = null;

                if (imagenBytes != null) {
                    icon = new ImageIcon(imagenBytes);
                }

                // Mostrar los datos
                textoObjeto.setText(nombre); 
                textoDescripcion.setText(descripcion); 
                imagenCargada.setIcon(icon); 
            } else {
                // No hay más registros
                JOptionPane.showMessageDialog(null, "No hay más registros.");
                indiceActual--; // Decrementar el índice si no hay más registros
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el registro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
});

        expertoFrame.add(botonAdelante);
    
    
     // Botón "Reversa"
    JButton botonReversa = new JButton("");
    ImageIcon iconoReversa = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\left.png"); 
    botonReversa.setIcon(iconoReversa);
    Image imgReversa = iconoReversa.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
    botonReversa.setIcon(new ImageIcon(imgReversa));
    botonReversa.setBounds(450, 470, 70, 50);

botonReversa.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonReversa.setForeground(Color.WHITE); // Color de texto
botonReversa.setBorderPainted(false); // Ocultar el borde
botonReversa.setFocusPainted(false); // Quitar el borde de enfoque
botonReversa.setOpaque(false); // Asegurarte de que el fondo se muestre
botonReversa.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

    botonReversa.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (indiceActual > 0) {
            indiceActual--;
            mostrarRegistro(indiceActual, textoObjeto, textoDescripcion, imagenCargada);
        } else {
            JOptionPane.showMessageDialog(null, "Ya estás en el primer registro.");
        }
    }
});

    expertoFrame.add(botonReversa);
    
 // Botón Final
JButton botonFinal = new JButton("");
ImageIcon iconoFinal = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\end.png"); 
botonFinal.setIcon(iconoFinal);
Image imgFinal = iconoFinal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
botonFinal.setIcon(new ImageIcon(imgFinal));
botonFinal.setBounds(650, 470, 70, 50); // Ajusta la posición según sea necesario


botonFinal.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonFinal.setForeground(Color.WHITE); // Color de texto
botonFinal.setBorderPainted(false); // Ocultar el borde
botonFinal.setFocusPainted(false); // Quitar el borde de enfoque
botonFinal.setOpaque(false); // Asegurarte de que el fondo se muestre
botonFinal.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonFinal.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Conectar a la base de datos y obtener el último registro
        String url = "jdbc:mysql://localhost:3306/objeto"; 
        String user = "root"; 
        String password = "S1lw0lf.2002"; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT nombre, descripcion, imagen FROM objetos ORDER BY id DESC LIMIT 1"; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre");
                String descripcion = rs.getString("descripcion");
                byte[] imagenBytes = rs.getBytes("imagen");
                ImageIcon icon = null;

                if (imagenBytes != null) {
                    icon = new ImageIcon(imagenBytes);
                }

                // Mostrar los datos en los componentes correspondientes
                textoObjeto.setText(nombre); 
                textoDescripcion.setText(descripcion);
                imagenCargada.setIcon(icon);

                // Hacer visibles los campos solo para visualizar
                textoObjeto.setEnabled(true);
                textoDescripcion.setEnabled(true);
                imagenCargada.setEnabled(true);
                
                // Desactivar inicialmente los campos para evitar edición
                textoObjeto.setEditable(false);
                textoDescripcion.setEditable(false);
                
                // Establecer indiceActual al último registro
                // Debes obtener el total de registros para establecer correctamente el índice
                // Supongamos que ya tienes un método para contar los registros
                int totalRegistros = obtenerTotalRegistros(conn); // Método que debes implementar
                indiceActual = totalRegistros - 1; // Asignar el índice del último registro
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron registros.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el registro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
});

// Agregar el botón a la ventana
expertoFrame.add(botonFinal);  



// Botón "Reiniciar"
JButton botonReiniciar = new JButton("");
ImageIcon iconoReiniciar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\restart.png"); 
botonReiniciar.setIcon(iconoReiniciar);
Image imgReiniciar = iconoReiniciar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
botonReiniciar.setIcon(new ImageIcon(imgReiniciar));
botonReiniciar.setBounds(500, 550, 70, 50); // Ajusta la posición según sea necesario


botonReiniciar.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonReiniciar.setForeground(Color.WHITE); // Color de texto
botonReiniciar.setBorderPainted(false); // Ocultar el borde
botonReiniciar.setFocusPainted(false); // Quitar el borde de enfoque
botonReiniciar.setOpaque(false); // Asegurarte de que el fondo se muestre
botonReiniciar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonReiniciar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Limpiar los campos
        textoObjeto.setText(""); // Limpiar el campo de texto del nombre
        textoDescripcion.setText(""); // Limpiar el área de texto de la descripción
        imagenCargada.setIcon(null); // Limpiar el JLabel de la imagen

        // Hacer editables los campos de texto para agregar un nuevo registro
        textoObjeto.setEditable(true);
        textoDescripcion.setEditable(true);

        // Habilitar los campos de nuevo para que el usuario pueda interactuar con ellos
        textoObjeto.setEnabled(true);
        textoDescripcion.setEnabled(true);
        imagenCargada.setEnabled(true);

        //JOptionPane.showMessageDialog(null, "Los campos han sido reiniciados para agregar un nuevo registro.");
    }
});

// Agregar el botón a la ventana
expertoFrame.add(botonReiniciar);

        //---------------------------------- Botón Salir
        JButton botonSalir = new JButton("");
        botonSalir.setBounds(1300, 750, 80, 60);
        ImageIcon iconoSalir = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\exit.png"); 
botonSalir.setIcon(iconoSalir);
Image img = iconoSalir.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonSalir.setIcon(new ImageIcon(img));

botonSalir.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonSalir.setForeground(Color.WHITE); // Color de texto
botonSalir.setBorderPainted(false); // Ocultar el borde
botonSalir.setFocusPainted(false); // Quitar el borde de enfoque
botonSalir.setOpaque(false); // Asegurarte de que el fondo se muestre
botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expertoFrame.dispose(); // Cerrar la ventana
            }
        });
      
        expertoFrame.add(botonSalir);
        
       expertoFrame.add(backgroundLabel);
        expertoFrame.setVisible(true);
    }
//------------------------------------------------------------------------------------------------------------------------------------------
 
 
 
 
 
 
 
 
 
 
 //-----------------------------------Motsrar Ventana Sintomas---------------------------------------
  private static void mostrarVentanaCaracteristicas() {
        JFrame expertoFrame = new JFrame();
        expertoFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizar la ventana
        expertoFrame.setUndecorated(true); 
        expertoFrame.setLayout(null); 

        
    ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\fondo11.jpg");
    Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1920, 1030, Image.SCALE_SMOOTH);
    JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
    backgroundLabel.setBounds(0, 0, 1920, 1030); // Ajustar el tamaño del JLabel al JFrame menos la altura del título

        
        // Panel para el título
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(250, 0, 1080, 50); 
        titlePanel.setBackground(Color.GRAY); 
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel titleLabel = new JLabel("Datos Sintomas");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30)); 
        titlePanel.add(titleLabel);
        expertoFrame.add(titlePanel);

        // Cuadro de texto para el nombre del objeto
        JLabel labelObjeto = new JLabel("SINTOMA:");
        labelObjeto.setBounds(370, 300, 200, 30);
        JTextField textoObjeto = new JTextField();
        textoObjeto.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente personalizada
        // Cambiar el color de fondo del ComboBox
        textoObjeto.setBackground(Color.BLACK); // Cambia LIGHT_GRAY por el color que desees
        // Cambiar el color del texto dentro del ComboBox
         textoObjeto.setForeground(Color.WHITE); // Cambia BLACK por el color que desees

        textoObjeto.setBounds(440, 300, 260, 30);
        expertoFrame.add(labelObjeto);
        expertoFrame.add(textoObjeto);

        // Panel con borde para la imagen cargada
        JPanel panelImagen = new JPanel();
        panelImagen.setBounds(1000, 150, 300, 300);
        panelImagen.setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
        panelImagen.setLayout(new BorderLayout());
        JLabel imagenCargada = new JLabel(); 
        imagenCargada.setHorizontalAlignment(JLabel.CENTER);
        imagenCargada.setVerticalAlignment(JLabel.CENTER);
        panelImagen.add(imagenCargada); 
        expertoFrame.add(panelImagen); 

    // Botón para cargar imagen
JButton botonImagen = new JButton("");
botonImagen.setBounds(1120, 470, 50, 50);
ImageIcon iconoImg = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\addimage.png");
botonImagen.setIcon(iconoImg);
Image imgAI = iconoImg.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonImagen.setIcon(new ImageIcon(imgAI));

botonImagen.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonImagen.setForeground(Color.WHITE); // Color de texto
botonImagen.setBorderPainted(false); // Ocultar el borde
botonImagen.setFocusPainted(false); // Quitar el borde de enfoque
botonImagen.setOpaque(false); // Asegurarte de que el fondo se muestre
botonImagen.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonImagen.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        
        // Establecer la ruta inicial donde se abrirá el JFileChooser
        fileChooser.setCurrentDirectory(new File("C:\\Users\\bambi\\OneDrive\\Documents\\Sintomas"));

        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
            Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
            imagenCargada.setIcon(new ImageIcon(img));
        }
    }
});
expertoFrame.add(botonImagen);

        
        
       // Botón Alta SINTOMAS
JButton botonAlta = new JButton("");
ImageIcon iconoAlta = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\added.png"); 
botonAlta.setIcon(iconoAlta);
Image imgA = iconoAlta.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonAlta.setIcon(new ImageIcon(imgA));

botonAlta.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonAlta.setForeground(Color.WHITE); // Color de texto
botonAlta.setBorderPainted(false); // Ocultar el borde
botonAlta.setFocusPainted(false); // Quitar el borde de enfoque
botonAlta.setOpaque(false); // Asegurarte de que el fondo se muestre
botonAlta.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonAlta.setBounds(250, 650, 80, 60);
botonAlta.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Almacenar el nuevo objeto
        String nombre = textoObjeto.getText();
      //  String descripcion = textoDescripcion.getText();
        ImageIcon imagen = (ImageIcon) imagenCargada.getIcon();

        if (!nombre.isEmpty() && imagen != null) {
            // Convertir la imagen a un arreglo de bytes
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            try {
                Image img = imagen.getImage();
                BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                Graphics g = bufferedImage.createGraphics();
                g.drawImage(img, 0, 0, null);
                g.dispose();
                ImageIO.write(bufferedImage, "png", baos);
                byte[] imagenBytes = baos.toByteArray();

                // Guardar en la base de datos
                String url = "jdbc:mysql://localhost:3306/objeto"; 
                String user = "root"; 
                String password = "S1lw0lf.2002"; 
                
                try (java.sql.Connection conn = DriverManager.getConnection(url, user, password)) {
                    // Verificar si el nombre ya existe (ignorando mayúsculas/minúsculas)
                    String checkSql = "SELECT COUNT(*) FROM sintomas WHERE LOWER(nombre_sintoma) = LOWER(?)";
                    try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                        checkStmt.setString(1, nombre);
                        ResultSet rs = checkStmt.executeQuery();
                        if (rs.next() && rs.getInt(1) > 0) {
                            JOptionPane.showMessageDialog(null, "El nombre ya existe. No se puede duplicar.");
                        } else {
                            // Si no existe, insertar el nuevo registro
                            String sql = "INSERT INTO sintomas (nombre_sintoma, imagen_sintoma) VALUES (?, ?)";
                            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                                pstmt.setString(1, nombre);
                             //   pstmt.setString(2, descripcion);
                                pstmt.setBytes(2, imagenBytes);
                                pstmt.executeUpdate();
                                JOptionPane.showMessageDialog(null, "Registro agregado correctamente.");
                                
                                // Limpiar los campos después de agregar
                                textoObjeto.setText(""); 
                               // textoDescripcion.setText(""); 
                                imagenCargada.setIcon(null); 
                            }
                        }
                    }
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + ex.getMessage());
                    ex.printStackTrace();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error al procesar la imagen: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre, la descripción y cargar una imagen.");
        }
    }
});
expertoFrame.add(botonAlta);

        
        
      

// Botón Baja
JButton botonBaja = new JButton("");
botonBaja.setBounds(390, 650, 80, 60);
ImageIcon iconoBaja = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\delete.png"); 
botonBaja.setIcon(iconoBaja);
Image imgB = iconoBaja.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonBaja.setIcon(new ImageIcon(imgB));
botonBaja.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonBaja.setForeground(Color.WHITE); // Color de texto
botonBaja.setBorderPainted(false); // Ocultar el borde
botonBaja.setFocusPainted(false); // Quitar el borde de enfoque
botonBaja.setOpaque(false); // Asegurarte de que el fondo se muestre
botonBaja.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonBaja.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Conectar a la base de datos y verificar si hay registros
        String url = "jdbc:mysql://localhost:3306/objeto"; // Cambia "tu_base_de_datos" por el nombre real
        String user = "root"; // Cambia "usuario" por el nombre de usuario correcto
        String password = "S1lw0lf.2002"; // Cambia "contraseña" por la contraseña correcta
        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT COUNT(*) FROM sintomas"; // Consulta para contar el número de registros
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                // Si hay registros, abrir la ventana emergente para eliminar
                JFrame bajaFrame = new JFrame("Eliminar Registro");
                bajaFrame.setSize(400, 100);
                bajaFrame.setLayout(new FlowLayout());
                bajaFrame.setLocationRelativeTo(null);
                
                JComboBox<String> comboRegistros = new JComboBox<>();
                
                // Llenar el combo con los nombres de los objetos
                String sqlRegistros = "SELECT nombre_sintoma FROM sintomas";
                PreparedStatement pstmtRegistros = conn.prepareStatement(sqlRegistros);
                ResultSet rsRegistros = pstmtRegistros.executeQuery();
                while (rsRegistros.next()) {
                    comboRegistros.addItem(rsRegistros.getString("nombre_sintoma"));
                }

                bajaFrame.add(comboRegistros);
                
                JButton confirmarEliminar = new JButton("Eliminar");
                confirmarEliminar.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String nombreSeleccionado = (String) comboRegistros.getSelectedItem();
                        
                        // Conectar a la base de datos y eliminar el registro seleccionado
                        try (Connection conn = DriverManager.getConnection(url, user, password)) {
                            String sql = "DELETE FROM sintomas WHERE nombre_sintoma = ?";
                            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                                pstmt.setString(1, nombreSeleccionado);
                                int filasAfectadas = pstmt.executeUpdate();
                                if (filasAfectadas > 0) {
                                    JOptionPane.showMessageDialog(null, "Registro eliminado correctamente.");
                                    
                                    // Limpiar la selección y el combo
                                    comboRegistros.removeItem(nombreSeleccionado); // Remover el elemento eliminado del combo
                                    if (comboRegistros.getItemCount() > 0) {
                                        comboRegistros.setSelectedIndex(0); // Seleccionar el primer elemento si queda
                                    } else {
                                        comboRegistros.setSelectedIndex(-1); // Si no queda ninguno, reiniciar selección
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se encontró el registro a eliminar.");
                                }
                            }
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + ex.getMessage());
                            ex.printStackTrace();
                        }
                        bajaFrame.dispose(); // Cerrar la ventana de baja
                    }
                });
                bajaFrame.add(confirmarEliminar);
                
                bajaFrame.setVisible(true);
            } else {
                // Si no hay registros, mostrar un mensaje y no hacer nada
                JOptionPane.showMessageDialog(null, "No hay registros en la base de datos para eliminar.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en la conexión a la base de datos: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
});
expertoFrame.add(botonBaja);





        
        
// Botón Consultar
JButton botonConsultar = new JButton("");
ImageIcon iconoConsultar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\search.png");
botonConsultar.setIcon(iconoConsultar);
Image imgCon = iconoConsultar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonConsultar.setIcon(new ImageIcon(imgCon));
botonConsultar.setBounds(530, 650, 80, 60);

botonConsultar.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonConsultar.setForeground(Color.WHITE); // Color de texto
botonConsultar.setBorderPainted(false); // Ocultar el borde
botonConsultar.setFocusPainted(false); // Quitar el borde de enfoque
botonConsultar.setOpaque(false); // Asegurarte de que el fondo se muestre
botonConsultar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonConsultar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Conectar a la base de datos y verificar si hay registros
        String url = "jdbc:mysql://localhost:3306/objeto"; 
        String user = "root"; 
        String password = "S1lw0lf.2002"; 
        
        boolean hayRegistros = false; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT COUNT(*) AS total FROM sintomas"; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hayRegistros = rs.getInt("total") > 0; 
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar la base de datos: " + ex.getMessage());
            ex.printStackTrace();
        }

        // Si no hay registros
        if (!hayRegistros) {
            JOptionPane.showMessageDialog(null, "No existen registros en la base de datos.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return; 
        }

        // Si hay registros, mostrar opciones
        String[] opciones = {"Particular", "General"};
        int seleccion = JOptionPane.showOptionDialog(null, "¿Qué tipo de consulta deseas hacer?", "Seleccionar consulta",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);

        if (seleccion == 0) { // Particular
            List<String> nombresRegistros = new ArrayList<>();

            // Cargar los nombres de los objetos
            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String sql = "SELECT nombre_sintoma FROM sintomas";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    nombresRegistros.add(rs.getString("nombre_sintoma"));
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al consultar registros: " + ex.getMessage());
                ex.printStackTrace();
            }

            // Mostrar un JComboBox con los nombres
            JComboBox<String> comboParticular = new JComboBox<>(nombresRegistros.toArray(new String[0]));
            int respuesta = JOptionPane.showConfirmDialog(null, comboParticular, "Selecciona un registro", JOptionPane.OK_CANCEL_OPTION);

            if (respuesta == JOptionPane.OK_OPTION) {
                String nombreSeleccionado = (String) comboParticular.getSelectedItem();
               

                if (nombreSeleccionado != null) {
                    try (Connection conn = DriverManager.getConnection(url, user, password)) {
                        String sql = "SELECT nombre_sintoma, imagen_sintoma FROM sintomas WHERE nombre_sintoma=?";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, nombreSeleccionado);
                        ResultSet rs = pstmt.executeQuery();

                        if (rs.next()) {
                            String nombre = rs.getString("nombre_sintoma");

                            // Imagen como BLOB
                            byte[] imagenBytes = rs.getBytes("imagen_sintoma");
                            ImageIcon icon = null;

                            if (imagenBytes != null) {
                                // Convertir a ImageIcon y escalar
                                icon = new ImageIcon(imagenBytes);
                                Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                                icon = new ImageIcon(img);
                            }

                         
                            JPanel panelDetalles = new JPanel();
                            panelDetalles.setLayout(new BorderLayout());
                            panelDetalles.add(new JLabel(nombre), BorderLayout.NORTH);
                            //panelDetalles.add(scrollPaneDesc, BorderLayout.CENTER);

                            JOptionPane.showMessageDialog(null, panelDetalles, "Detalle del Registro", JOptionPane.INFORMATION_MESSAGE, icon);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al obtener detalles del registro: " + ex.getMessage());
                    }
                }
            }
        } else if (seleccion == 1) { // General
            // Mostrar la tabla con los registros
            String[] columnNames = {"Nombre del sintoma", "Imagen del sintoma"};
            List<Object[]> dataList = new ArrayList<>();

            try (Connection conn = DriverManager.getConnection(url, user, password)) {
                String sql = "SELECT nombre_sintoma, imagen_sintoma FROM sintomas"; 
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();

                while (rs.next()) {
                    String nombre = rs.getString("nombre_sintoma");
                   // String descripcion = rs.getString("descripcion");

                    byte[] imagenBytes = rs.getBytes("imagen_sintoma");
                    ImageIcon icon = null;

                    if (imagenBytes != null) {
                        icon = new ImageIcon(imagenBytes);
                        Image img = icon.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
                        icon = new ImageIcon(img);
                    }

                  

                    
                    // Usar HTML para mostrar el nombre con ajuste de línea
                    String nombreConFormato = "<html><body style='width: 115px;text-align: center; margin-top: 10px;'>" +
                               nombre + "</body></html>";

                    dataList.add(new Object[]{nombreConFormato, icon});
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al consultar registros: " + ex.getMessage());
                ex.printStackTrace();
            }

            // Crear tabla
            Object[][] data = new Object[dataList.size()][2];
            for (int i = 0; i < dataList.size(); i++) {
                data[i] = dataList.get(i);
            }

            JTable table = new JTable(data, columnNames) {
                @Override
                public Class<?> getColumnClass(int column) {
                    return column == 1 ? ImageIcon.class : Object.class;
                }
            };

            table.getColumnModel().getColumn(0).setPreferredWidth(70); // Nombre
            table.getColumnModel().getColumn(1).setPreferredWidth(150); // Imagen
            table.setRowHeight(200);

            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(800, 600));

            // Mostrar el JScrollPane
            JOptionPane.showMessageDialog(null, scrollPane, "Registros Almacenados", JOptionPane.PLAIN_MESSAGE);
        }
    }
});

expertoFrame.add(botonConsultar);



        
        
// Botón Modificación
JButton botonModificar = new JButton("");
botonModificar.setBounds(690, 650, 70, 60);
ImageIcon iconoModificar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\edit.png");
botonModificar.setIcon(iconoModificar);
Image imgM = iconoModificar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
botonModificar.setIcon(new ImageIcon(imgM));

botonModificar.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonModificar.setForeground(Color.WHITE); // Color de texto
botonModificar.setBorderPainted(false); // Ocultar el borde
botonModificar.setFocusPainted(false); // Quitar el borde de enfoque
botonModificar.setOpaque(false); // Asegurarte de que el fondo se muestre
botonModificar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonModificar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Cargar objetos desde la base de datos
        List<Caract> objetos = cargarCaracteristicasDesdeBaseDeDatos();
        
        // Verificar si hay objetos en la base de datos
        if (objetos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay registros disponibles para modificar.");
            return; // No mostrar la ventana si no hay registros
        }

        // Crear ventana emergente para modificar el registro
        JFrame modificarFrame = new JFrame("Modificar Registro");
        modificarFrame.setSize(800, 500);
        modificarFrame.setUndecorated(true);
        modificarFrame.setLocationRelativeTo(null);

        ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\fondo12.jpg");
        Image backgroundImage = backgroundIcon.getImage().getScaledInstance(800, 500, Image.SCALE_SMOOTH);
        JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, 800, 500);

        // ComboBox para seleccionar el objeto a modificar
        JComboBox<String> comboRegistros = new JComboBox<>();
        comboRegistros.addItem(""); // Agregar un elemento vacío
        // Cambiar el color de fondo del ComboBox
        comboRegistros.setBackground(Color.BLACK); // Cambia LIGHT_GRAY por el color que desees
        // Cambiar el color del texto dentro del ComboBox
        comboRegistros.setForeground(Color.WHITE); // Cambia BLACK por el color que desees

        comboRegistros.setBounds(50, 150, 300, 30); // Posición del comboBox
        modificarFrame.add(comboRegistros);

        // Etiquetas y campos para el nuevo nombre
        JLabel labelNombreMod = new JLabel("Nuevo Nombre:");
        labelNombreMod.setBounds(50, 220, 100, 30);
        labelNombreMod.setForeground(Color.BLACK);
        modificarFrame.add(labelNombreMod);

        JTextField textoNombreMod = new JTextField(20);
        textoNombreMod.setBounds(150, 220, 200, 30);
        modificarFrame.add(textoNombreMod);

        // Panel con borde para la imagen cargada
        JPanel panelImagenMod = new JPanel();
        panelImagenMod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelImagenMod.setLayout(new BorderLayout());
        JLabel imagenCargadaMod = new JLabel();
        imagenCargadaMod.setHorizontalAlignment(JLabel.CENTER);
        imagenCargadaMod.setVerticalAlignment(JLabel.CENTER);
        panelImagenMod.add(imagenCargadaMod);
        panelImagenMod.setBounds(400, 30, 300, 300);
        modificarFrame.add(panelImagenMod);

        // Botón para cargar nueva imagen
        JButton botonImagenMod = new JButton("");
        botonImagenMod.setBounds(520, 340, 60, 50);
        ImageIcon iconoModificarFrame = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\addimage.png");
        botonImagenMod.setIcon(iconoModificarFrame);
        Image imgMF = iconoModificarFrame.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        botonImagenMod.setIcon(new ImageIcon(imgMF));

        botonImagenMod.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
        botonImagenMod.setForeground(Color.WHITE); // Color de texto
        botonImagenMod.setBorderPainted(false); // Ocultar el borde
        botonImagenMod.setFocusPainted(false); // Quitar el borde de enfoque
        botonImagenMod.setOpaque(false); // Asegurarte de que el fondo se muestre
        botonImagenMod.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

        botonImagenMod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File("C:\\Users\\bambi\\OneDrive\\Documents\\Sintomas"));

                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    ImageIcon icon = new ImageIcon(selectedFile.getAbsolutePath());
                    Image img = icon.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
                    imagenCargadaMod.setIcon(new ImageIcon(img));
                }
            }
        });
        modificarFrame.add(botonImagenMod);

        // Agregar objetos al JComboBox
        for (Caract obj : objetos) {
            comboRegistros.addItem(obj.nombre_sintoma); // Agregar el nombre al combo
        }

        // Cargar datos del registro seleccionado en el JComboBox
        comboRegistros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) comboRegistros.getSelectedItem();
                if (nombreSeleccionado.isEmpty()) {
                    return; // No hacer nada si el elemento seleccionado es vacío
                }

                Caract objetoSeleccionado = objetos.stream()
                    .filter(obj -> obj.nombre_sintoma.equals(nombreSeleccionado))
                    .findFirst().orElse(null);
                
                if (objetoSeleccionado != null) {
                    // Cargar datos en los campos de texto
                    textoNombreMod.setText(objetoSeleccionado.nombre_sintoma); // Cargar el nombre del síntoma
                    // Cargar la imagen del objeto seleccionado
                    imagenCargadaMod.setIcon(objetoSeleccionado.imagen_sintoma);
                }
            }
        });

        // Botón para confirmar la modificación
        JButton confirmarModificar = new JButton("");
        confirmarModificar.setBounds(310, 420, 140, 50);
        ImageIcon iconoBM = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\editbutton.png");
        confirmarModificar.setIcon(iconoBM);
        Image imgBM = iconoBM.getImage().getScaledInstance(320, 140, Image.SCALE_SMOOTH);
        confirmarModificar.setIcon(new ImageIcon(imgBM));

        confirmarModificar.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
        confirmarModificar.setForeground(Color.WHITE); // Color de texto
        confirmarModificar.setBorderPainted(false); // Ocultar el borde
        confirmarModificar.setFocusPainted(false); // Quitar el borde de enfoque
        confirmarModificar.setOpaque(false); // Asegurarte de que el fondo se muestre
        confirmarModificar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

        confirmarModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreSeleccionado = (String) comboRegistros.getSelectedItem();
                Caract objetoAModificar = objetos.stream()
                    .filter(obj -> obj.nombre_sintoma.equals(nombreSeleccionado))
                    .findFirst().orElse(null);
                
                // Validar que se haya cargado una imagen
                ImageIcon nuevaImagen = (ImageIcon) imagenCargadaMod.getIcon();
                
                if (nuevaImagen == null) {
                    JOptionPane.showMessageDialog(null, "Debe cargar una imagen.");
                    return;
                }

                // Permitir que el usuario deje el nombre en blanco
                String nuevoNombre = textoNombreMod.getText().trim();

                if (objetoAModificar != null) {
                    // Actualizar el nombre del síntoma solo si no está vacío
                    if (!nuevoNombre.isEmpty()) {
                        objetoAModificar.nombre_sintoma = nuevoNombre;
                    }
                    objetoAModificar.imagen_sintoma = nuevaImagen;

                    // Actualizar en la base de datos
                    String url = "jdbc:mysql://localhost:3306/objeto"; // Cambia por tu nombre real de base de datos
                    String user = "root"; // Cambia por el nombre de usuario correcto
                    String password = "S1lw0lf.2002"; // Cambia por la contraseña correcta

                    try (Connection conn = DriverManager.getConnection(url, user, password)) {
                        String sql = "UPDATE sintomas SET nombre_sintoma=?, imagen_sintoma=? WHERE nombre_sintoma=?";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setString(1, nuevoNombre.isEmpty() ? objetoAModificar.nombre_sintoma : nuevoNombre); // Si el nombre es vacío, conservar el original
                        // Convertir la imagen a bytes
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        Image img = nuevaImagen.getImage();
                        BufferedImage bufferedImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_RGB);
                        Graphics g = bufferedImage.createGraphics();
                        g.drawImage(img, 0, 0, null);
                        g.dispose();
                        ImageIO.write(bufferedImage, "jpg", baos);
                        pstmt.setBytes(2, baos.toByteArray());

                        pstmt.setString(3, nombreSeleccionado);
                        pstmt.executeUpdate();

                        JOptionPane.showMessageDialog(null, "Registro modificado correctamente.");
                       modificarFrame.dispose(); // Cerrar ventana de modificación
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, "Error al modificar el registro en la base de datos: " + ex.getMessage());
                        ex.printStackTrace();
                    } catch (IOException ioEx) {
                        JOptionPane.showMessageDialog(null, "Error al convertir la imagen: " + ioEx.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Error al modificar el registro.");
                }
            }
        });
        JButton botonSalir = new JButton("");
        botonSalir.setBounds(745, 420, 40, 40);
        ImageIcon iconoSalir = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\exit.png");
        botonSalir.setIcon(iconoSalir);
Image img = iconoSalir.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonSalir.setIcon(new ImageIcon(img));

botonSalir.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonSalir.setForeground(Color.WHITE); // Color de texto
botonSalir.setBorderPainted(false); // Ocultar el borde
botonSalir.setFocusPainted(false); // Quitar el borde de enfoque
botonSalir.setOpaque(false); // Asegurarte de que el fondo se muestre
botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarFrame.dispose(); // Cerrar la ventana
            }
        });

        modificarFrame.add(botonSalir);
        modificarFrame.add(confirmarModificar);

        // Añadir el fondo al JFrame
        modificarFrame.add(backgroundLabel);
        modificarFrame.setLayout(null);
        modificarFrame.setVisible(true);
    }
});
expertoFrame.add(botonModificar);



// Botón Inicio
JButton botonInicio = new JButton("");
ImageIcon iconoInicio = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\home.png"); 
botonInicio.setIcon(iconoInicio);
Image imgInicio = iconoInicio.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
botonInicio.setIcon(new ImageIcon(imgInicio));
botonInicio.setBounds(350, 470,70, 50); // Ajusta la posición según sea necesario


botonInicio.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonInicio.setForeground(Color.WHITE); // Color de texto
botonInicio.setBorderPainted(false); // Ocultar el borde
botonInicio.setFocusPainted(false); // Quitar el borde de enfoque
botonInicio.setOpaque(false); // Asegurarte de que el fondo se muestre
botonInicio.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonInicio.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Conectar a la base de datos y obtener el primer registro
        String url = "jdbc:mysql://localhost:3306/objeto"; // Cambia "tu_base_de_datos" por el nombre real
        String user = "root"; // Cambia "usuario" por el nombre de usuario correcto
        String password = "S1lw0lf.2002"; // Cambia "contraseña" por la contraseña correcta

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT nombre_sintoma, imagen_sintoma FROM sintomas LIMIT 1"; // Solo obtén el primer registro
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre_sintoma");
                //String descripcion = rs.getString("descripcion");
                byte[] imagenBytes = rs.getBytes("imagen_sintoma");
                ImageIcon icon = null;

                if (imagenBytes != null) {
                    icon = new ImageIcon(imagenBytes);
                }

                // Mostrar los datos en los componentes correspondientes
                textoObjeto.setText(nombre);
                //textoDescripcion.setText(descripcion);
                imagenCargada.setIcon(icon);

                // Hacer visibles los campos solo para visualizar
                textoObjeto.setEnabled(true); 
               // textoDescripcion.setEnabled(true); 
                imagenCargada.setEnabled(true);

                // Desactivar inicialmente los campos para evitar edición
                textoObjeto.setEditable(false); 
               // textoDescripcion.setEditable(false); 

                // Reiniciar el índice actual
                indiceActual = 0; // Reiniciar el índice
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron registros.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el registro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
});

// Agregar el botón a la ventana
expertoFrame.add(botonInicio);





// Botón Adelante
        JButton botonAdelante = new JButton("");
        ImageIcon iconoAdelante = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\right.png");
        botonAdelante.setIcon(iconoAdelante);
        Image imgAdelante = iconoAdelante.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
        botonAdelante.setIcon(new ImageIcon(imgAdelante));
        botonAdelante.setBounds(550, 470, 70, 50); // Ajusta la posición según sea necesario

        
botonAdelante.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonAdelante.setForeground(Color.WHITE); // Color de texto
botonAdelante.setBorderPainted(false); // Ocultar el borde
botonAdelante.setFocusPainted(false); // Quitar el borde de enfoque
botonAdelante.setOpaque(false); // Asegurarte de que el fondo se muestre
botonAdelante.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

        botonAdelante.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (indiceActual == -1) {
            JOptionPane.showMessageDialog(null, "Por favor, presione el botón Inicio primero.");
            return;
        }

        // Conectar a la base de datos y obtener el siguiente registro
        String url = "jdbc:mysql://localhost:3306/objeto"; 
        String user = "root"; 
        String password = "S1lw0lf.2002"; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            indiceActual++; // Incrementar el índice

            String sql = "SELECT nombre_sintoma, imagen_sintoma FROM sintomas LIMIT 1 OFFSET ?"; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, indiceActual); // Establecer el OFFSET

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String nombre = rs.getString("nombre_sintoma");
                //String descripcion = rs.getString("descripcion");
                byte[] imagenBytes = rs.getBytes("imagen_sintoma");
                ImageIcon icon = null;

                if (imagenBytes != null) {
                    icon = new ImageIcon(imagenBytes);
                }

                // Mostrar los datos
                textoObjeto.setText(nombre); 
                //textoDescripcion.setText(descripcion); 
                imagenCargada.setIcon(icon); 
            } else {
                // No hay más registros
                JOptionPane.showMessageDialog(null, "No hay más registros.");
                indiceActual--; // Decrementar el índice si no hay más registros
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el registro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
});

        expertoFrame.add(botonAdelante);
    
    
     // Botón "Reversa"
    JButton botonReversa = new JButton("");
    ImageIcon iconoReversa = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\left.png"); 
    botonReversa.setIcon(iconoReversa);
    Image imgReversa = iconoReversa.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
    botonReversa.setIcon(new ImageIcon(imgReversa));
    botonReversa.setBounds(450, 470, 70, 50);

    
botonReversa.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonReversa.setForeground(Color.WHITE); // Color de texto
botonReversa.setBorderPainted(false); // Ocultar el borde
botonReversa.setFocusPainted(false); // Quitar el borde de enfoque
botonReversa.setOpaque(false); // Asegurarte de que el fondo se muestre
botonReversa.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

    botonReversa.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (indiceActual > 0) {
            indiceActual--;
            mostrarRegistroCaracteristicas(indiceActual, textoObjeto, imagenCargada);
        } else {
            JOptionPane.showMessageDialog(null, "Ya estás en el primer registro.");
        }
    }
});

    expertoFrame.add(botonReversa);
    
 // Botón Final
JButton botonFinal = new JButton("");
ImageIcon iconoFinal = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\end.png"); 
botonFinal.setIcon(iconoFinal);
Image imgFinal = iconoFinal.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
botonFinal.setIcon(new ImageIcon(imgFinal));
botonFinal.setBounds(650, 470, 70, 50); // Ajusta la posición según sea necesario

botonFinal.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonFinal.setForeground(Color.WHITE); // Color de texto
botonFinal.setBorderPainted(false); // Ocultar el borde
botonFinal.setFocusPainted(false); // Quitar el borde de enfoque
botonFinal.setOpaque(false); // Asegurarte de que el fondo se muestre
botonFinal.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonFinal.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Conectar a la base de datos y obtener el último registro
        String url = "jdbc:mysql://localhost:3306/objeto"; 
        String user = "root"; 
        String password = "S1lw0lf.2002"; 

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT nombre_sintoma, imagen_sintoma FROM sintomas ORDER BY id DESC LIMIT 1"; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            if (rs.next()) {
                String nombre = rs.getString("nombre_sintoma");
                //String descripcion = rs.getString("descripcion");
                byte[] imagenBytes = rs.getBytes("imagen_sintoma");
                ImageIcon icon = null;

                if (imagenBytes != null) {
                    icon = new ImageIcon(imagenBytes);
                }

                // Mostrar los datos en los componentes correspondientes
                textoObjeto.setText(nombre); 
               // textoDescripcion.setText(descripcion);
                imagenCargada.setIcon(icon);

                // Hacer visibles los campos solo para visualizar
                textoObjeto.setEnabled(true);
                //textoDescripcion.setEnabled(true);
                imagenCargada.setEnabled(true);
                
                // Desactivar inicialmente los campos para evitar edición
                textoObjeto.setEditable(false);
                //textoDescripcion.setEditable(false);
                
                // Establecer indiceActual al último registro
                // Debes obtener el total de registros para establecer correctamente el índice
                // Supongamos que ya tienes un método para contar los registros
                int totalRegistros = obtenerTotalRegistrosCaracteristicas(conn); // Método que debes implementar
                indiceActual = totalRegistros - 1; // Asignar el índice del último registro
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron registros.");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al consultar el registro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
});

// Agregar el botón a la ventana
expertoFrame.add(botonFinal);  



// Botón "Reiniciar"
JButton botonReiniciar = new JButton("");
ImageIcon iconoReiniciar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\restart.png"); 
botonReiniciar.setIcon(iconoReiniciar);
Image imgReiniciar = iconoReiniciar.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH); 
botonReiniciar.setIcon(new ImageIcon(imgReiniciar));
botonReiniciar.setBounds(500, 550, 70, 50); // Ajusta la posición según sea necesario


botonReiniciar.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonReiniciar.setForeground(Color.WHITE); // Color de texto
botonReiniciar.setBorderPainted(false); // Ocultar el borde
botonReiniciar.setFocusPainted(false); // Quitar el borde de enfoque
botonReiniciar.setOpaque(false); // Asegurarte de que el fondo se muestre
botonReiniciar.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonReiniciar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Limpiar los campos
        textoObjeto.setText(""); // Limpiar el campo de texto del nombre
        //textoDescripcion.setText(""); // Limpiar el área de texto de la descripción
        imagenCargada.setIcon(null); // Limpiar el JLabel de la imagen

        // Hacer editables los campos de texto para agregar un nuevo registro
        textoObjeto.setEditable(true);
        //textoDescripcion.setEditable(true);

        // Habilitar los campos de nuevo para que el usuario pueda interactuar con ellos
        textoObjeto.setEnabled(true);
        //textoDescripcion.setEnabled(true);
        imagenCargada.setEnabled(true);

        //JOptionPane.showMessageDialog(null, "Los campos han sido reiniciados para agregar un nuevo registro.");
    }
});

// Agregar el botón a la ventana
expertoFrame.add(botonReiniciar);

        //---------------------------------- Botón Salir
        JButton botonSalir = new JButton("");
        botonSalir.setBounds(1300, 750, 80, 60);
        ImageIcon iconoSalir = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\exit.png"); 
botonSalir.setIcon(iconoSalir);
Image img = iconoSalir.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonSalir.setIcon(new ImageIcon(img));

botonSalir.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonSalir.setForeground(Color.WHITE); // Color de texto
botonSalir.setBorderPainted(false); // Ocultar el borde
botonSalir.setFocusPainted(false); // Quitar el borde de enfoque
botonSalir.setOpaque(false); // Asegurarte de que el fondo se muestre
botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón
        botonSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                expertoFrame.dispose(); // Cerrar la ventana
            }
        });
      
        expertoFrame.add(botonSalir);
        
       expertoFrame.add(backgroundLabel);
        expertoFrame.setVisible(true);
    }
//--------------------------------------------------------------------------------------------------------------------------------------------
 
 
 
 
 
 //-------------------------------------------------Ventana Cuadro Relacion------------------------------------------------------------------
private static void mostrarVentanaCuadroRelacion() {
    // Cargar objetos y síntomas desde la base de datos
    List<Objeto> objetos = cargarObjetosDesdeBaseDeDatos();
    List<Caract> sintomas = cargarCaracteristicasDesdeBaseDeDatos(); // Asegúrate de tener esta función

    // Crear ventana emergente para modificar el registro
    JFrame modificarFrame = new JFrame("");
    modificarFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);  // Maximizar la ventana
    modificarFrame.setUndecorated(true);
    modificarFrame.setLocationRelativeTo(null);

    ImageIcon backgroundIcon = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\fondowhite.jpg");
    Image backgroundImage = backgroundIcon.getImage().getScaledInstance(1920, 1080, Image.SCALE_SMOOTH);
    JLabel backgroundLabel = new JLabel(new ImageIcon(backgroundImage));
    backgroundLabel.setBounds(0, 0, 1920, 1080);


 // Panel para el título
        JPanel titlePanel = new JPanel();
        titlePanel.setBounds(250, 0, 1080, 50); 
        titlePanel.setBackground(Color.GRAY); 
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel titleLabel = new JLabel("Cuadro-Relacion");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 30)); 
        titlePanel.add(titleLabel);
        modificarFrame.add(titlePanel);
    
    // ComboBox para seleccionar ENFERMEDADES
    JLabel labelObjeto = new JLabel("ENFERMEDAD:");
    JComboBox<Objeto> comboRegistros = new JComboBox<>();
    labelObjeto.setBounds(250, 170, 200, 30);
    comboRegistros.addItem(null);
    comboRegistros.setFont(new Font("Arial", Font.BOLD, 13)); // Fuente personalizada
    comboRegistros.setBounds(380, 170, 160, 30);
    modificarFrame.add(comboRegistros);
    modificarFrame.add(labelObjeto);

    // ComboBox para seleccionar SINTOMAS
    JLabel labelSintoma = new JLabel("SINTOMA:");
    JComboBox<Caract> sintomasRegistros = new JComboBox<>();
    labelSintoma.setBounds(290, 300, 200, 30);
    sintomasRegistros.addItem(null);
    sintomasRegistros.setFont(new Font("Arial", Font.BOLD, 13)); // Fuente personalizada
    sintomasRegistros.setBounds(380, 300, 160, 30);
    modificarFrame.add(sintomasRegistros);
    modificarFrame.add(labelSintoma);

    // Panel con borde para la imagen cargada
    JPanel panelImagenMod = new JPanel();
    panelImagenMod.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    panelImagenMod.setLayout(new BorderLayout());
    JLabel imagenCargadaMod = new JLabel();
    imagenCargadaMod.setHorizontalAlignment(JLabel.CENTER);
    imagenCargadaMod.setVerticalAlignment(JLabel.CENTER);
    panelImagenMod.add(imagenCargadaMod);
    panelImagenMod.setBounds(1000, 150, 300, 300);
    modificarFrame.add(panelImagenMod);

    // Agregar objetos al JComboBox de ENFERMEDADES
    for (Objeto obj : objetos) {
        comboRegistros.addItem(obj);
    }

    // Agregar síntomas al JComboBox de SINTOMAS
    for (Caract sintoma : sintomas) {
        sintomasRegistros.addItem(sintoma);
    }

    // Crear un modelo de tabla
    DefaultTableModel tableModel = new DefaultTableModel();
    tableModel.addColumn("Síntoma");
    tableModel.addColumn("Peso");
    

    // JTable para mostrar los síntomas seleccionados
    JTable tableSintomas = new JTable(tableModel);
    tableSintomas.setBounds(600, 300, 400, 200);
    tableSintomas.setFont(new Font("Arial", Font.BOLD, 13)); // Fuente personalizada
    tableSintomas.setFillsViewportHeight(true);
    JScrollPane scrollPane = new JScrollPane(tableSintomas);
    scrollPane.setBounds(400, 500, 400, 200);
    modificarFrame.add(scrollPane);

    
   // Al seleccionar una enfermedad, cargar los síntomas y sus pesos correspondientes
   List<String> sintomasGuardados = new ArrayList<>();
   List<String> sintomasNuevos = new ArrayList<>();
   List<String> sintomasAgregados = new ArrayList<>();

comboRegistros.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Objeto objetoSeleccionado = (Objeto) comboRegistros.getSelectedItem();
        if (objetoSeleccionado != null) {
            imagenCargadaMod.setIcon(objetoSeleccionado.imagen);

            // Limpiar la tabla antes de cargar nuevos datos
            tableModel.setRowCount(0);

            // Limpiar las listas de síntomas
            sintomasGuardados.clear();
            sintomasNuevos.clear();

            // Cargar los síntomas y pesos asociados con el objeto seleccionado
            try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/objeto", "root", "S1lw0lf.2002")) {
                PreparedStatement stmt = connection.prepareStatement(
                    "SELECT s.nombre_sintoma, r.peso " +
                    "FROM relacion r " +
                    "JOIN sintomas s ON r.sintoma_id = s.id " +
                    "WHERE r.objeto_id = ?");
                stmt.setInt(1, objetoSeleccionado.id);
                ResultSet rs = stmt.executeQuery();

                // Añadir los síntomas y pesos a la tabla
                while (rs.next()) {
                    String sintomaNombre = rs.getString("nombre_sintoma");
                    String peso = rs.getString("peso");
                    tableModel.addRow(new Object[]{sintomaNombre, peso});
                    sintomasGuardados.add(sintomaNombre); // Agregar a la lista de síntomas guardados
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(modificarFrame, "Error al cargar los síntomas: " + ex.getMessage());
            }
        }
    }
});


    // Crear JTextField para ingresar peso
    JLabel labelPeso = new JLabel("PESO                  %");
    labelPeso.setBounds(650, 300, 700, 30);
    modificarFrame.add(labelPeso);

    JTextField pesoField = new JTextField();
    pesoField.setBounds(700, 300, 30, 30);
    pesoField.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente personalizada
    modificarFrame.add(pesoField);

    


// Botón Añadir
JButton añadirButton = new JButton("");
añadirButton.setBounds(550, 380, 80, 70);
ImageIcon iconoAñadir = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\added.png");
añadirButton.setIcon(iconoAñadir);
Image imgAdd = iconoAñadir.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 40, 40 por el tamaño que necesites
añadirButton.setIcon(new ImageIcon(imgAdd));

// Estilos del botón

añadirButton.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
añadirButton.setForeground(Color.WHITE); // Color de texto
añadirButton.setBorderPainted(false); // Ocultar el borde
añadirButton.setFocusPainted(false); // Quitar el borde de enfoque
añadirButton.setOpaque(false); // Asegurarte de que el fondo se muestre
añadirButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

añadirButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String pesoTexto = pesoField.getText();
        Caract sintomaSeleccionado = (Caract) sintomasRegistros.getSelectedItem();
        Objeto objetoSeleccionado = (Objeto) comboRegistros.getSelectedItem();

        // Verificar si hay un síntoma seleccionado
        if (sintomaSeleccionado == null) {
            JOptionPane.showMessageDialog(modificarFrame, "Por favor, selecciona un síntoma para añadir peso.");
            return;
        }

        // Verificar si el campo de peso está vacío
        if (pesoTexto.isEmpty()) {
            JOptionPane.showMessageDialog(modificarFrame, "Por favor, ingresa un peso.");
            return;
        }

        // Verificar si el síntoma ya está en el JTable
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            String sintomaExistente = (String) tableModel.getValueAt(i, 0);
            String pesoExistente = (String) tableModel.getValueAt(i, 1);

            // Si el síntoma ya existe en el JTable, mostrar un mensaje y salir
            if (sintomaExistente.equals(sintomaSeleccionado.nombre_sintoma)) {
                JOptionPane.showMessageDialog(modificarFrame, "El síntoma '" + sintomaSeleccionado.nombre_sintoma + "' ya ha sido agregado con el peso de " + pesoExistente + ".");
                return; // Salir si ya existe en el JTable
            }
        }

        // Verificar si el síntoma ya está en la base de datos para el objeto seleccionado
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/objeto", "root", "S1lw0lf.2002")) {
            // Verificar si ya existe el síntoma en la misma enfermedad
            PreparedStatement stmtVerificar = connection.prepareStatement(
                "SELECT peso FROM relacion WHERE objeto_id = ? AND sintoma_id = (SELECT id FROM sintomas WHERE nombre_sintoma = ?)");
            stmtVerificar.setInt(1, objetoSeleccionado.id);
            stmtVerificar.setString(2, sintomaSeleccionado.nombre_sintoma);
            ResultSet rsVerificar = stmtVerificar.executeQuery();

            if (rsVerificar.next()) {
                String pesoExistenteDB = rsVerificar.getString("peso");
                JOptionPane.showMessageDialog(modificarFrame, "El síntoma '" + sintomaSeleccionado.nombre_sintoma + "' ya ha sido agregado para esta enfermedad con el peso de '" + pesoExistenteDB + "'");
                return; // Salir si ya existe en la base de datos
            }

            // Si el síntoma no existe en la base de datos o en el JTable, agregarlo a la tabla
            tableModel.addRow(new Object[]{sintomaSeleccionado.nombre_sintoma, pesoTexto});
            sintomasAgregados.add(sintomaSeleccionado.nombre_sintoma); // Agregar a la lista de síntomas agregados
            sintomasNuevos.add(sintomaSeleccionado.nombre_sintoma); // Agregar a la lista de síntomas nuevos
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(modificarFrame, "Error al verificar el síntoma: " + ex.getMessage());
        }

        // Limpiar el campo de peso después de añadir
        pesoField.setText("");
    }
});
modificarFrame.add(añadirButton);


// Botón Guardar
JButton guardarButton = new JButton("");
ImageIcon iconoGuardar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\save.png");
guardarButton.setIcon(iconoGuardar);
Image imgG = iconoGuardar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 40, 40 por el tamaño que necesites
guardarButton.setIcon(new ImageIcon(imgG));

// Estilos del botón
guardarButton.setBounds(450, 730, 80, 70);
guardarButton.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
guardarButton.setForeground(Color.WHITE); // Color de texto
guardarButton.setBorderPainted(false); // Ocultar el borde
guardarButton.setFocusPainted(false); // Quitar el borde de enfoque
guardarButton.setOpaque(false); // Asegurarte de que el fondo se muestre
guardarButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón




guardarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Objeto objetoSeleccionado = (Objeto) comboRegistros.getSelectedItem();
        if (objetoSeleccionado == null) {
            JOptionPane.showMessageDialog(modificarFrame, "Por favor, selecciona una enfermedad.");
            return;
        }

        // Guardar cada síntoma y peso en la tabla relacion
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/objeto", "root", "S1lw0lf.2002")) {
            boolean datosGuardados = false; // Bandera para comprobar si se guardaron datos
            boolean hayDuplicados = false;  // Bandera para comprobar si hay duplicados
            double sumaTotalPesos = 0.0;    // Variable para sumar los nuevos pesos

            for (int i = 0; i < tableModel.getRowCount(); i++) {
                String sintomaNombre = (String) tableModel.getValueAt(i, 0);
                String peso = (String) tableModel.getValueAt(i, 1);
                double pesoDouble = Double.parseDouble(peso); // Convertir el peso a tipo double

                PreparedStatement stmtSintoma = connection.prepareStatement(
                    "SELECT id FROM sintomas WHERE nombre_sintoma = ?");
                stmtSintoma.setString(1, sintomaNombre);
                ResultSet rsSintoma = stmtSintoma.executeQuery();

                if (rsSintoma.next()) {
                    int sintomaId = rsSintoma.getInt("id");

                    // Verificar si ya existe el síntoma en la misma enfermedad
                    PreparedStatement stmtVerificar = connection.prepareStatement(
                        "SELECT COUNT(*) FROM relacion WHERE objeto_id = ? AND sintoma_id = ?");
                    stmtVerificar.setInt(1, objetoSeleccionado.id);
                    stmtVerificar.setInt(2, sintomaId);
                    ResultSet rsVerificar = stmtVerificar.executeQuery();

                    if (rsVerificar.next()) {
                        int count = rsVerificar.getInt(1);
                        if (count > 0) {
                            // Hay un duplicado, marcar la bandera
                            hayDuplicados = true;
                            continue; // Continuar con el siguiente síntoma
                        }
                    }

                    // Insertar en la tabla relacion
                    PreparedStatement stmtInsertar = connection.prepareStatement(
                        "INSERT INTO relacion (objeto_id, sintoma_id, peso) VALUES (?, ?, ?)");
                    stmtInsertar.setInt(1, objetoSeleccionado.id);
                    stmtInsertar.setInt(2, sintomaId);
                    stmtInsertar.setDouble(3, pesoDouble); // Usar pesoDouble directamente
                    stmtInsertar.executeUpdate();

                    // Añadir el síntoma a la lista de guardados
                    sintomasGuardados.add(sintomaNombre);

                    datosGuardados = true; // Indicar que se guardó al menos un dato
                    sumaTotalPesos += pesoDouble; // Sumar el peso actual al total
                }
            }

            // Obtener la sumatoria actual de la tabla objetos
            PreparedStatement stmtSumatoria = connection.prepareStatement(
                "SELECT sumatoria FROM objetos WHERE id = ?");
            stmtSumatoria.setInt(1, objetoSeleccionado.id);
            ResultSet rsSumatoria = stmtSumatoria.executeQuery();

            double sumatoriaActual = 0.0; // Valor por defecto si no hay suma previa
            if (rsSumatoria.next()) {
                sumatoriaActual = rsSumatoria.getDouble("sumatoria");
            }

            // Calcular la nueva sumatoria acumulativa
            double nuevaSumatoria = sumatoriaActual + sumaTotalPesos;

            // Actualizar la sumatoria en la tabla objetos
            if (datosGuardados) {
                PreparedStatement stmtActualizarObjeto = connection.prepareStatement(
                    "UPDATE objetos SET sumatoria = ? WHERE id = ?");
                stmtActualizarObjeto.setDouble(1, nuevaSumatoria);
                stmtActualizarObjeto.setInt(2, objetoSeleccionado.id);
                stmtActualizarObjeto.executeUpdate();
            }

            // Mostrar mensaje final
            if (datosGuardados) {
                JOptionPane.showMessageDialog(modificarFrame, "Datos guardados exitosamente.");
                // Limpiar los campos: ComboBox, JTextField y tabla
                comboRegistros.setSelectedIndex(-1);
                sintomasRegistros.setSelectedIndex(-1);
                pesoField.setText("");
                tableModel.setRowCount(0);
                // Limpiar la imagen mostrada
                imagenCargadaMod.setIcon(null); // Esto eliminará la imagen actual del JLabel
                // Limpiar la lista de síntomas nuevos ya que se han guardado
                sintomasNuevos.clear();
            } else if (hayDuplicados) {
                //JOptionPane.showMessageDialog(modificarFrame, "No puedes guardar datos ya registrados.");
            } else {
                JOptionPane.showMessageDialog(modificarFrame, "No se guardaron nuevos datos.");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(modificarFrame, "Error al guardar los datos: " + ex.getMessage());
        }
    }
});
modificarFrame.add(guardarButton);


// Botón Borrar
JButton borrarButton = new JButton("");
borrarButton.setBounds(830, 600, 60, 70); // Posicionar el botón de borrar
ImageIcon iconoBorrar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\delete.png");
borrarButton.setIcon(iconoBorrar);
Image imgB = iconoBorrar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 40, 40 por el tamaño que necesites
borrarButton.setIcon(new ImageIcon(imgB));

// Estilos del botón

borrarButton.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
borrarButton.setForeground(Color.WHITE); // Color de texto
borrarButton.setBorderPainted(false); // Ocultar el borde
borrarButton.setFocusPainted(false); // Quitar el borde de enfoque
borrarButton.setOpaque(false); // Asegurarte de que el fondo se muestre
borrarButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

// Establecer una fuente
borrarButton.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente personalizada


borrarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Borrar el síntoma seleccionado del JTable
        int selectedRow = tableSintomas.getSelectedRow();
        if (selectedRow != -1) {
            String sintomaNombre = (String) tableModel.getValueAt(selectedRow, 0);

            // Verificar si el síntoma está en la lista de síntomas nuevos
            if (sintomasNuevos.contains(sintomaNombre)) { // Solo borrar si está en la lista de nuevos
                tableModel.removeRow(selectedRow);
                sintomasAgregados.remove(sintomaNombre);
                sintomasNuevos.remove(sintomaNombre); // Remover de la lista de nuevos
                
            } 
            /*else {
                JOptionPane.showMessageDialog(modificarFrame, "El síntoma '" + sintomaNombre + "' no puede ser borrado porque ya ha sido guardado.");
            }*/
        } else {
            JOptionPane.showMessageDialog(modificarFrame, "Por favor, selecciona un síntoma para borrar.");
        }
    }
});
modificarFrame.add(borrarButton);

 
  // Botón Cancelar
JButton cancelarButton = new JButton("");
cancelarButton.setBounds(650, 730, 80, 60);
ImageIcon iconoCancelar = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\cancel.png");
cancelarButton.setIcon(iconoCancelar);
Image imgCan = iconoCancelar.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 40, 40 por el tamaño que necesites
cancelarButton.setIcon(new ImageIcon(imgCan));

// Estilos del botón

cancelarButton.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
cancelarButton.setForeground(Color.WHITE); // Color de texto
cancelarButton.setBorderPainted(false); // Ocultar el borde
cancelarButton.setFocusPainted(false); // Quitar el borde de enfoque
cancelarButton.setOpaque(false); // Asegurarte de que el fondo se muestre
cancelarButton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

// Establecer una fuente
cancelarButton.setFont(new Font("Arial", Font.BOLD, 14)); // Fuente personalizada

cancelarButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Crear botones personalizados
        Object[] opciones = {"Sí", "No"};

        // Mostrar cuadro de diálogo de confirmación
        int respuesta = JOptionPane.showOptionDialog(modificarFrame,
                "¿Estás seguro de que deseas cancelar?",
                "Confirmar cancelación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                opciones,
                opciones[1]); // predeterminado a "No"

        // Si el usuario selecciona "Sí", limpiar el JTable y otros campos de entrada
        if (respuesta == 0) { // 0 es el índice de "Sí"
            tableModel.setRowCount(0); // Limpiar los síntomas y pesos de la tabla
            comboRegistros.setSelectedIndex(-1); // Restablecer el JComboBox de enfermedades
            
            // Limpiar los campos: ComboBox, JTextField y tabla
            sintomasRegistros.setSelectedIndex(-1);
            pesoField.setText("");
            imagenCargadaMod.setIcon(null); // Esto eliminará la imagen actual del JLabel
            
            
        }
    }
});
modificarFrame.add(cancelarButton);

// Botón Salir
JButton botonSalir = new JButton("");
botonSalir.setBounds(1300, 750, 80, 60);
ImageIcon iconoSalir = new ImageIcon("C:\\Users\\bambi\\OneDrive\\Pictures\\IA Project U2\\exit.png");
botonSalir.setIcon(iconoSalir);
Image img = iconoSalir.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH); // Cambia 20, 20 por el tamaño que necesites
botonSalir.setIcon(new ImageIcon(img));
// Estilos del botón

botonSalir.setBackground(new Color(100, 149, 237)); // Color de fondo (ej. azul)
botonSalir.setForeground(Color.WHITE); // Color de texto
botonSalir.setBorderPainted(false); // Ocultar el borde
botonSalir.setFocusPainted(false); // Quitar el borde de enfoque
botonSalir.setOpaque(false); // Asegurarte de que el fondo se muestre
botonSalir.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar el cursor al pasar el ratón

botonSalir.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        // Crear botones personalizados
        Object[] opciones = {"Sí", "No"};
        
        // Mostrar cuadro de diálogo de confirmación
        int respuesta = JOptionPane.showOptionDialog(modificarFrame,
                "¿Estás seguro de que quieres salir?",
                "Confirmar salida",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                opciones,
                opciones[1]); // predeterminado a "No"

        // Si el usuario selecciona "Sí", cerrar la ventana
        if (respuesta == 0) { // 0 es el índice de "Sí"
            modificarFrame.dispose(); // Cerrar la ventana
        }
    }
});

modificarFrame.add(botonSalir);


    // Configuración final de la ventana
    modificarFrame.add(backgroundLabel);
    modificarFrame.setLayout(null);
    modificarFrame.setVisible(true);
}
//--------------------------------------------------------------------------------------------------------------------------------------------
 
 
 
 
    
  //----------------------------------------------------------------------------------------------------------  
  static class Objeto implements Serializable {
    int id;
    String nombre;
    String descripcion;
    ImageIcon imagen;

     Objeto(int id, String nombre, String descripcion, ImageIcon imagen) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }

    // Sobrescribimos toString para que el JComboBox muestre el nombre
    @Override
    public String toString() {
        return nombre; // Mostrar el nombre del objeto en el JComboBox
    }
}
 //---------------------------------------------------------------------------------------------------------- 
  
  
  
  
  
  
   //---------------------------------------------------------------------------------------------------------- 
     // Clase para representar los objetos
    static class Caract implements Serializable {
        int id;
        String nombre_sintoma;
        ImageIcon imagen_sintoma;

         
    Caract(String nombre, ImageIcon imagen) {
        this.id = id;     
        this.nombre_sintoma = nombre;
           
            this.imagen_sintoma = imagen;
        }
         @Override
    public String toString() {
        return nombre_sintoma; // Esto asegura que se muestre el nombre en el JComboBox
    }
        
    }
   //---------------------------------------------------------------------------------------------------------- 
  
    
    
    
    
    
    
  //----------------------------------------------------------------------------------------------------------    
// Método para cargar objetos desde la base de datos
public static List<Objeto> cargarObjetosDesdeBaseDeDatos() {
    List<Objeto> objetos = new ArrayList<>();
    String url = "jdbc:mysql://localhost:3306/objeto"; // Cambia por tu nombre real de base de datos
    String user = "root"; // Cambia por el nombre de usuario correcto
    String password = "S1lw0lf.2002"; // Cambia por la contraseña correcta

    try (Connection conn = DriverManager.getConnection(url, user, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT id, nombre, descripcion, imagen FROM objetos")) { // Obtén también el ID
        
        while (rs.next()) {
            int id = rs.getInt("id"); // Obtén el ID
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            byte[] imgBytes = rs.getBytes("imagen");
            ImageIcon imagen = new ImageIcon(imgBytes);
            
            // Asegúrate de que el constructor de Objeto acepte el ID
            objetos.add(new Objeto(id, nombre, descripcion, imagen)); 
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return objetos;
}
 //---------------------------------------------------------------------------------------------------------- 






 //---------------------------------------------------------------------------------------------------------- 
 // Método para cargar Caracteristicas desde la base de datos
public static List<Caract> cargarCaracteristicasDesdeBaseDeDatos() {
    List<Caract> Caract = new ArrayList<>();
    String url = "jdbc:mysql://localhost:3306/objeto"; // Cambia por tu nombre real de base de datos
    String user = "root"; // Cambia por el nombre de usuario correcto
    String password = "S1lw0lf.2002"; // Cambia por la contraseña correcta

    try (Connection conn = DriverManager.getConnection(url, user, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery("SELECT nombre_sintoma, imagen_sintoma FROM sintomas")) {
        
        while (rs.next()) {
            String nombre = rs.getString("nombre_sintoma");
            //String descripcion = rs.getString("descripcion");
            byte[] imgBytes = rs.getBytes("imagen_sintoma");
            ImageIcon imagen = new ImageIcon(imgBytes);
            Caract.add(new Caract(nombre, imagen));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return Caract;
}
 //---------------------------------------------------------------------------------------------------------- 




 //---------------------------------------------------------------------------------------------------------- 
// Variable global para el índice actual de registro
static int indiceActual = 0;

private static void mostrarRegistro(int indice, JTextField textoObjeto, JTextArea textoDescripcion, JLabel imagenCargada) {
    String url = "jdbc:mysql://localhost:3306/objeto"; 
    String user = "root"; 
    String password = "S1lw0lf.2002"; 

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        String sql = "SELECT nombre, descripcion, imagen FROM objetos LIMIT 1 OFFSET ?"; // Usar OFFSET para navegar
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, indice); // Establecer el índice del registro a mostrar
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            
            // Recuperar la imagen como BLOB
            byte[] imagenBytes = rs.getBytes("imagen");
            ImageIcon icon = null;

            if (imagenBytes != null) {
                icon = new ImageIcon(imagenBytes); // Convertir los bytes a ImageIcon
            }

            // Mostrar los datos en los componentes correspondientes
            textoObjeto.setText(nombre); 
            textoDescripcion.setText(descripcion); 
            imagenCargada.setIcon(icon); 
        } else {
            JOptionPane.showMessageDialog(null, "Has alcanzado el último registro.");
            indiceActual--; // Retroceder el índice si no hay más registros
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al consultar el registro: " + ex.getMessage());
        ex.printStackTrace();
    }
}
 //---------------------------------------------------------------------------------------------------------- 








 //---------------------------------------------------------------------------------------------------------- 
private static void mostrarRegistroCaracteristicas(int indice, JTextField textoObjeto, JLabel imagenCargada) {
    String url = "jdbc:mysql://localhost:3306/objeto"; 
    String user = "root"; 
    String password = "S1lw0lf.2002"; 

    try (Connection conn = DriverManager.getConnection(url, user, password)) {
        String sql = "SELECT nombre_sintoma, imagen_sintoma FROM sintomas LIMIT 1 OFFSET ?"; // Usar OFFSET para navegar
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, indice); // Establecer el índice del registro a mostrar
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            String nombre = rs.getString("nombre_sintoma");
            //String descripcion = rs.getString("descripcion");
            
            // Recuperar la imagen como BLOB
            byte[] imagenBytes = rs.getBytes("imagen_sintoma");
            ImageIcon icon = null;

            if (imagenBytes != null) {
                icon = new ImageIcon(imagenBytes); // Convertir los bytes a ImageIcon
            }

            // Mostrar los datos en los componentes correspondientes
            textoObjeto.setText(nombre); 
            //textoDescripcion.setText(descripcion); 
            imagenCargada.setIcon(icon); 
        } else {
            JOptionPane.showMessageDialog(null, "Has alcanzado el último registro.");
            indiceActual--; // Retroceder el índice si no hay más registros
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al consultar el registro: " + ex.getMessage());
        ex.printStackTrace();
    }
}
 //---------------------------------------------------------------------------------------------------------- 







 //---------------------------------------------------------------------------------------------------------- 
// Método para obtener el total de registros
private static int obtenerTotalRegistros(Connection conn) throws SQLException {
    String sql = "SELECT COUNT(*) AS total FROM objetos";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
        return rs.getInt("total");
    }
    return 0;
}
 //---------------------------------------------------------------------------------------------------------- 





 //---------------------------------------------------------------------------------------------------------- 
// Método para obtener el total de registros
private static int obtenerTotalRegistrosCaracteristicas(Connection conn) throws SQLException {
    String sql = "SELECT COUNT(*) AS total FROM sintomas";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
    if (rs.next()) {
        return rs.getInt("total");
    }
    return 0;
}
 //---------------------------------------------------------------------------------------------------------- 

 
}
