from PySide6.QtWidgets import QApplication, QLabel, QWidget, QLineEdit

class Ventana(QWidget):
    
    def __init__(self):
        super().__init__()
        
        self.setWindowTitle("Ventana")
        self.etiqueta = QLabel(self)
        self.texto = QLineEdit(self)
        self.texto.setMaximumSize(50, 30)
        self.texto.setMaxLength(5)
        self.etiqueta.move(50,0)
        
        self.texto.textChanged.connect(self.etiqueta.setText)
       
       
app = QApplication([])
ventana = Ventana()
ventana.show()
app.exec()