from PySide6.QtWidgets import(
    QApplication, 
    QMainWindow,
    QDialog,
    QPushButton,
    QDialogButtonBox,
    QVBoxLayout,
    QLabel,
    QMessageBox
)
from PySide6.QtCore import(
    QLibraryInfo,
    QTranslator
)

class DialogoPersonalizado(QDialog):
    
    def __init__(self, parent = None):
        
        super().__init__(parent)
        self.setWindowTitle("Diálogo personalizado")
        
        #Definimos los botones OK y Cancel en nuestra variable
        botones = QDialogButtonBox.Ok | QDialogButtonBox.Cancel
        
        #Pasamos la variable de botones al constructor de QDialogButtonBox
        self.cajaBotones = QDialogButtonBox(botones)
        
        #Conectamos las señales de los botones con las ranuras de QDialog
        self.cajaBotones.accepted.connect(self.accept)
        self.cajaBotones.rejected.connect(self.reject)
        
        #Añadimos un QLabel y el QDialogButtonBox en un layout vertical
        self.layoutDialogo = QVBoxLayout()
        self.layoutDialogo.addWidget(QLabel("¿Estás seguro de querer realizar esta acción?"))
        self.layoutDialogo.addWidget(self.cajaBotones)
        self.setLayout(self.layoutDialogo)

class VentanaPrincipal(QMainWindow):
    
    def __init__(self):
        
        super().__init__()
        self.setWindowTitle("Aplicación con diálogo personalizado")
        boton = QPushButton("Haz clic para que el diálogo aparezca")
        boton.clicked.connect(self.mostrarDialogo)
        self.setCentralWidget(boton)
    
    def mostrarDialogo(self):
        print("Clic recibido, se mostrará el diálogo.")
        
        #Creamos un objeto QDialog con nuestra aplicación como parent
        vetanaDialogo = DialogoPersonalizado(self)
        vetanaDialogo.setWindowTitle("Ventana de diálogo personalizado")
        
        #Nos guardamos el resultado de la ejecución del diálogo:
        #1 si se ejecuta la ranura accept
        #0 si se ejecuta reject
        resultado = vetanaDialogo.exec()
        
        if (resultado):
            print("Aceptada")
            QMessageBox.information(self, "Confirmación", "Aceptada")
        else:
            print("Cancelada")
            QMessageBox.critical(self, "Confirmación", "Cancelada")
            
def cargarTraductor(app):
    translator = QTranslator(app)
    translations = QLibraryInfo.location(QLibraryInfo.TranslationsPath)
    translator.load("qt_es", translations)
    app.installTranslator(translator)
            
app = QApplication([])
cargarTraductor(app)
ventana = VentanaPrincipal()
ventana.show()
app.exec()