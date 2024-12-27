from PySide6.QtWidgets import *

class VentanaPrincipal(QMainWindow):

    def __init__(self):
        
        super().__init__()
        self.setWindowTitle("Ventana Principal")        
        formulario = QFormLayout()
        componente_principal = QWidget()
        componente_principal.setLayout(formulario)
        usuario = QLineEdit()
        formulario.addRow("Usuario:", usuario)
        

class Login(QDialog):
    
    def __init__(self):
        
        super().__init__() 
        self.setWindowTitle("Login")
        
        layout_dialog = QVBoxLayout()
        boton = QPushButton("Pulsa")
        layout_dialog.addWidget(boton)

        self.setLayout(layout_dialog)
        
        boton.clicked.connect(self.mostrar_ventana)
    
    def mostrar_ventana(self):
        
        ventana = VentanaPrincipal()        
        ventana.show()
               
if __name__ == "__main__":
    app = QApplication([])
    ventana_login = Login()
    ventana_login.show()

    app.exec()