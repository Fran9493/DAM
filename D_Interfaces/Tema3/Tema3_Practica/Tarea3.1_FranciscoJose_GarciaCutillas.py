from PySide6.QtWidgets import QApplication, QWidget, QLabel, QVBoxLayout, QComboBox

class Meses(QWidget):
    """
    Clase elaborada para el desarrollo de una ventana en la que se imprime por terminal
    el mes y número de dicho mes, el cual está seleccionado en el ComboBox
    """

    def __init__(self):
        """
        Constructor de la clase. Sin parámetros
        """
        super().__init__()

        #Título de la ventana
        self.setWindowTitle("Tarea 3.1")
        self.resize(300, 200)
        
        #Configuración del diseño de la ventana
        layout = QVBoxLayout()
        
        #layout.addWidget(QLabel('Meses del año'))
                
        #Creo el ComboBox
        comMeses = QComboBox(self)
        layout.addWidget(comMeses)
        
        #Lista con los meses del año
        meses = ['Meses del año', 'Enero', 'Febrero', 'Marzo', 'Abril', 'Mayo', 'Junio', 'Julio', 'Agosto',
                    'Septiembre', 'Ocubre', 'Noviembre', 'Diciembre']
        
        #Añado los meses al ComboBox
        comMeses.addItems(meses)

        #Establezco el layout
        self.setLayout(layout)

        #Conexión del evento cambio de mes a la ranura imprimeTexto   
        comMeses.currentIndexChanged.connect(lambda: self.imprimeTexto(comMeses.currentIndex(), comMeses.currentText()))
                
    #Ranura que se ejecurará cuando cambie el elemento del comboBox
    def imprimeTexto (self, indice, mes):
        """
        Método imprimeTexto(self, indice, mes). Recibe el índice seleccionado del ComboBox de tipo int y
        el mes de tipo String y lo concatena para mostrarlo por terminal
        """

        #Texto e índice del mes seleccionado
        print(mes + " es el mes número " + str(indice) + ".")
        

if __name__ == "__main__":
    app = QApplication([])
    ventana = Meses()
    ventana.show()
    app.exec()