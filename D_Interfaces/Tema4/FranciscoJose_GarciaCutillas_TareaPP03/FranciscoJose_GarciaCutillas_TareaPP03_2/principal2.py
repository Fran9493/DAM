from PySide6.QtWidgets import *
from PySide6.QtUiTools import QUiLoader

#main
if __name__ == "__main__":
    """
    Ventana con un campo de texto, un botón para limpiar el texto que 
    haya escrito y un botón para maximizar la ventana.
    """         
    loader = QUiLoader()
    
    app = QApplication([])
    
    ventana = loader.load("ventana.ui", None)
    
    #Añadimos el placeHolder
    ventana.textEdit.setPlaceholderText("Escribe tu texto aquí...")
        
    ventana.show()
    
    app.exec()