from PySide6.QtWidgets import *
from PySide6.QtGui import *
from ventana_ui import Ui_MainWindow

class Ventana(QMainWindow, Ui_MainWindow):
    """
    Clase Ventana que hereda de QMainWindow y de Ui_MainWindow. Esta clase
        genera una ventana que consta de un campo de texto que suma o resta 
        unidad a unidad dependiendo de si pulsas en CountUp(sumar) o 
        CountDown(restar), y si pulsas sobre Reset, el campo se pondrá a 0
    """
        
    def __init__(self):
        """
        Constructor de la clase Ventana
        """
        
        super(Ventana, self).__init__()
        self.setupUi(self)
        
        self.contador = 0
        
        #Suma
        self.CountUp.clicked.connect(self.sumar)
        
        #Resta
        self.CountDown.clicked.connect(self.restar)
        
        #Reset
        self.Reset.clicked.connect(self.reset)
        
    #Funciones
    def sumar(self):
        """
        Función sumar. Cuando recibe la señal del botón CountUp, suma 1 al 
        contador y lo muestra por el QlineEdit.
        """
        self.contador += 1
        self.campoContador.setText(str(self.contador))
        
    def restar(self):
        """
        Función restar. Cuando recibe la señal del botón CountDown, resta 1 al 
        contador y lo muestra por el QlineEdit.
        """
        self.contador -= 1
        self.campoContador.setText(str(self.contador))
        
    def reset(self):
        """
        Función reset. Cuando recibe la señal del botón Reset, reestablece el 
        contador a 0 y lo muestra por el QlineEdit.
        """
        self.contador = 0
        self.campoContador.setText("0")
       

#main
if __name__ == "__main__":
    app = QApplication([])
    
    window = Ventana()

    window.show()
    
    app.exec()