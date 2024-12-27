from PySide6.QtWidgets import(
    QApplication, 
    QMainWindow,
    QDialog,
    QPushButton
)

class VentanaPrincipal(QMainWindow):
    
    def __init__(self):
        
        super().__init__()
        self.setWindowTitle("Aplicación con diálogos")
        boton = QPushButton("Haz clic para que el diálogo aparezca")
        boton.clicked.connect(self.mostrarDialogo)
        self.setCentralWidget(boton)
    
    def mostrarDialogo(self):
        print("Clic recibido, se mostrará el diálogo.")
        
        #Creamos un objeto QDialog con nuestra aplicación como parent
        vetanaDialogo = QDialog(self)
        vetanaDialogo.setWindowTitle("Ventana de diálogo")
        #Lanzamos su bucle de eventos
        vetanaDialogo.exec()
        
app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()