from PySide6.QtWidgets import (
    QApplication, QMainWindow, QWidget, QVBoxLayout, QHBoxLayout, 
    QPushButton, QLabel, QLineEdit, QFormLayout
)

class VentanaLogin(QMainWindow):
    """
    Clase VentanaLogin(). Elaborada para realizar una ventana de login con un usuario y una contraseña.
    Si el usuario y contraseña es correcto, mostrará el mensaje "Usuario correcto", de lo contrario
    mostrará el mensaje "Usuario incorrecto".    
    """

    def __init__(self):
        
        super().__init__()        
        self.setWindowTitle("Login")
        
        #Layout principal de la ventana
        layoutPrincipal = QVBoxLayout()
        
        #Añadimos un QWidget principal y se lo asignamos al layout principal
        componente_principal = QWidget()
        componente_principal.setLayout(layoutPrincipal)
        self.setCentralWidget(componente_principal)
       
        #Creamos un layout Formulario para el usuario y la contraseña, y lo añadimos al principal
        layoutFormulario = QFormLayout()
        self.qlineUsuario = QLineEdit()
        self.qlineUsuario.setPlaceholderText("Usuario")
        layoutFormulario.addRow(QLabel("Usuario:"), self.qlineUsuario)
        self.qlinePass = QLineEdit()
        self.qlinePass.setPlaceholderText("Contraseña")
        layoutFormulario.addRow(QLabel("Contraseña:"), self.qlinePass) 
        self.qlinePass.setEchoMode(QLineEdit.EchoMode.Password)    
        layoutPrincipal.addLayout(layoutFormulario)
        
        #Creamos el botón 
        layoutBoton = QHBoxLayout()
        boton = QPushButton("Login")
        layoutBoton.addWidget(boton)
        layoutPrincipal.addLayout(layoutBoton)
        
        boton.clicked.connect(self.mostrarTexto)
        
        #Creamos el elemento de confirmación de si el usuario y contraseña son correctos
        layoutConfirmacion = QHBoxLayout()
        self.qlabelCorrecto = QLabel("Usuario Correcto")
        self.qlabelCorrecto.setStyleSheet("color: green")
        layoutConfirmacion.addWidget(self.qlabelCorrecto)
        self.qlabelCorrecto.setHidden(True)        
        self.qlabelIncorrecto = QLabel("Usuario Incorrecto")
        self.qlabelIncorrecto.setStyleSheet("color: red")
        layoutConfirmacion.addWidget(self.qlabelIncorrecto)
        self.qlabelIncorrecto.setHidden(True)
        layoutPrincipal.addLayout(layoutConfirmacion)
                
    def mostrarTexto(self):
        """
        Método mostrarTexto(). Con este método al cual llamamos desde la acción de pulsar el botón de login,
        nos permitirá mostrar u ocultar el mensaje de si un usuario y una contraseña han sido metidos 
        correctamente o no.
        """
        
        if (self.qlineUsuario.text() == "admin" and self.qlinePass.text() == "admin"):
            self.qlabelCorrecto.setHidden(False)
            self.qlabelIncorrecto.setHidden(True)
        else:
            self.qlabelCorrecto.setHidden(True)
            self.qlabelIncorrecto.setHidden(False)
       
app = QApplication([])
ventana = VentanaLogin()
ventana.show()
app.exec()

