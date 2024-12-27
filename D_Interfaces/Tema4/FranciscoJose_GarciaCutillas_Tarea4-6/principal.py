from PySide6.QtWidgets import *
from PySide6.QtUiTools import QUiLoader



#main
if __name__ == "__main__":
        
    loader = QUiLoader()
    
    app = QApplication([])
    
    ventana = loader.load("conversor.ui", None)
    
    def celFah():
        """
        Función de conversión de grados Celsius a grados Fahrenheit.
        Comprueba mediante una excepción si en el campo Celsius se 
        introduce un valor distinto de numérico
        """
        try:            
            conversion = ((float)(ventana.campoCelsius.text()) * 9/5) + 32
            ventana.campoFahrenheit.setValue(conversion)
        except:
            ventana.campoCelsius.clear()
            ventana.campoCelsius.setFocus()
            ventana.campoCelsius.setPlaceholderText("Sólo admite números")
            
        
    def fahCel():
        """
        Función de conversión de grados Fahrenheit a grados Celsius. En este 
        caso no es necesario comprobar si se le introduce un tipo numérico,
        ya que por definición el Spin box no permite otro tipo de dato.
        """
        conversion = (str)(((ventana.campoFahrenheit.value()) - 32) * 5/9)
        ventana.campoCelsius.setText(conversion)
        
    ventana.celsiusFahrenheit.clicked.connect(celFah)
    ventana.fahrenheitCelsius.clicked.connect(fahCel)
    
    ventana.show()
    
    app.exec()