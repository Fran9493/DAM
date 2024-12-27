from PySide6.QtWidgets import *
from ui_calculadora import Ui_MainWindow

class Calculadora(QMainWindow, Ui_MainWindow):
    """
    Clase Calculadora  que hereda de QMainWindow y contiene la interfaz gráfica 
    de una calculadora con la que podemos seleccionar si queremos sumar, restar, 
    multiplicar o dividir dos valores introducidos.
    """
            
    def __init__(self):
        """
        Constructor de la clase Calculadora
        """
        
        super(Calculadora, self).__init__()
        self.setupUi(self)
                
        self.botonCalcular.clicked.connect(self.calcular)
        
        
    #Funciones
    def calcular(self):
        """
        Función calcular. Encargada de llamar a la función correspondiente al pulsar sobre
        el botón calcular, dependiendo del checkbox que haya pulsado.
        """
        if (self.radioButtonSumar.isChecked()):
            self.sumar()
        elif (self.radioButtonRestar.isChecked()):
            self.restar()
        elif (self.radioButtonMultiplicar.isChecked()):
            self.multiplicar()
        elif (self.radioButtonDividir.isChecked()):
            self.dividir()
        
    def sumar(self):
        """
        Función sumar. Suma los valores introducidos en los campos Valor 1 y Valor 2,
        y muestra el resultado en el campo Resultado.
        """
        resultado = (float)(self.lineEditValor1.text()) + (float)(self.lineEditValor2.text())
        self.lineEditResultado.setText((str)(resultado))
    
    def restar(self):
        """
        Función restar. Resta los valores introducidos en los campos Valor 1 y Valor 2,
        y muestra el resultado en el campo Resultado.
        """        
        resultado = (float)(self.lineEditValor1.text()) - (float)(self.lineEditValor2.text())
        self.lineEditResultado.setText((str)(resultado))
    
    def multiplicar(self):
        """
        Función multiplicar. Multiplica los valores introducidos en los campos Valor 1 y Valor 2,
        y muestra el resultado en el campo Resultado.
        """ 
        resultado = (float)(self.lineEditValor1.text()) * (float)(self.lineEditValor2.text())
        self.lineEditResultado.setText((str)(resultado))
    
    def dividir(self):
        """
        Función dividir. Divide los valores introducidos en los campos Valor 1 y Valor 2,
        y muestra el resultado en el campo Resultado.
        """
        resultado = (float)(self.lineEditValor1.text()) / (float)(self.lineEditValor2.text())
        self.lineEditResultado.setText((str)(resultado))

#main
if __name__ == "__main__":
    app = QApplication([])
    
    ventanaPrincipal = Calculadora()

    ventanaPrincipal.show()
    
    app.exec()