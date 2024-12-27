from PySide6.QtWidgets import *
from PySide6.QtGui import *
from PySide6.QtCore import *
from peliculas_ui import Ui_MainWindow

class Ventana(QMainWindow, Ui_MainWindow):
    """
    Clase Ventana que hereda de QMainWindow y de Ui_MainWindow. Esta clase
        genera una ventana que consta de un lineEdit, un listWidget y un
        botón añadir. Toda cadena de texto que haya en el lineEdit cuando se
        pulse sobre el botón añadir, se añadirá al listWidget reseteando el 
        lineEdit y colocando el foco sobre él
    """
        
    def __init__(self):
        """
        Constructor de la clase Ventana
        """
        
        super(Ventana, self).__init__()
        self.setupUi(self)
        self.setFixedSize(450, 200)
        
        self.botonAdd.clicked.connect(self.addPelicula)

    #Funciones
    def addPelicula(self):
        """
        Función encargada de transferir la cadena del lineEdit al listWidget
        al pulsar sobre añadir
        """ 
        if self.linePeliculas.text():       
            self.listPeliculas.addItem(self.linePeliculas.text())
            self.linePeliculas.clear()
            
        self.linePeliculas.setFocus()

#main
if __name__ == "__main__":
    app = QApplication([])
    
    ventanaPrincipal = Ventana()

    ventanaPrincipal.show()
    
    app.exec()