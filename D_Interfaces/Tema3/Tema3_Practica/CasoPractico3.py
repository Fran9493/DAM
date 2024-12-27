from PySide6.QtWidgets import *
from PySide6.QtGui import *

class VentanaPrincipal(QMainWindow):

    def __init__(self):
        
        super().__init__()
        
        self.setWindowTitle("Ventana principal")

        barra_menus = self.menuBar()
        menu = barra_menus.addMenu("&Menu")

        accion = QAction(QIcon("icono.png"),"&Imprimir por consola", self)
        accion.setWhatsThis("Al pulsar sobre el botón se imprimirá el texto en el dock")
        accion.triggered.connect(self.imprime_dock)
        menu.addAction(accion)

        accion_ayuda = QAction(QIcon("iconoAyuda.png"), "¿&Qué es esto?", self)
        accion_ayuda.triggered.connect(self.que_es_esto)
        menu.addAction(accion_ayuda)

        barra_herramientas = QToolBar("Barra de herramientas")
        barra_herramientas.setToolButtonStyle(Qt.ToolButtonTextUnderIcon)
        barra_herramientas.addAction(accion)
        barra_herramientas.addAction(accion_ayuda)
        self.addToolBar(barra_herramientas)

        dock = QDockWidget("Dock", self)
        self.contenido_dock = QTextEdit()
        dock.setWidget(self.contenido_dock)
        self.addDockWidget(Qt.BottomDockWidgetArea, dock)

    def imprime_dock(self):
        self.contenido_dock.setText("Acción pulsada\n")
    
    def que_es_esto(self):
        QWhatsThis.enterWhatsThisMode()




if __name__ == "__main__":
    app = QApplication([])
    ventana1 = VentanaPrincipal()
    ventana1.show()
    app.exec()