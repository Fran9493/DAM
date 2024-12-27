from PySide6.QtWidgets import *
from PySide6.QtGui import *
from PySide6.QtCore import *
from peliculas import Ui_MainWindow
from Recursos import Recursos_rc

class Ventana(QMainWindow, Ui_MainWindow):
    """
    Clase Ventana que hereda de QMainWindow y de Ui_MainWindow. Esta clase
        genera una ventana que consta de un lineEdit, un listWidget, un
        botón añadir, otro de aceptar y otro de limpiar. Ahora mismo no dispone
        de funcionalidad. Es sólo para probar los iconos. 
    """
        
    def __init__(self):
        """
        Constructor de la clase Ventana
        """
        
        super(Ventana, self).__init__()
        self.setupUi(self)

#main
if __name__ == "__main__":
    app = QApplication([])
    
    ventanaPrincipal = Ventana()

    ventanaPrincipal.show()
    
    app.exec()