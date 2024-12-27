from PySide6.QtWidgets import *
from ventana import Ui_MainWindow

class Ventana(QMainWindow, Ui_MainWindow):
    """
    Clase Ventana que se corresponde a una ventana con un campo de texto,
    un botón para limpiar el texto que haya escrito y un botón para maximizar
    la ventana.
    """    
    def __init__(self):
        """
        Constructor de la clase Ventana
        """        
        super(Ventana, self).__init__()
        self.setupUi(self)
        
        #Añadimos el placeHolder
        self.textEdit.setPlaceholderText("Escribe tu texto aquí...")
        
        

#main
if __name__ == "__main__":
    app = QApplication([])
    
    ventanaPrincipal = Ventana()

    ventanaPrincipal.show()
    
    app.exec()