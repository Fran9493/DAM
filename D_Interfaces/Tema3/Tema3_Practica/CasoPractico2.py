from PySide6.QtWidgets import QApplication, QMainWindow, QWidget, QVBoxLayout, QHBoxLayout, QPushButton

class VentanaPrincipal(QMainWindow):
    
    def __init__(self):
        
        super().__init__()        
        self.setWindowTitle("Ventana principal")
        
        layoutPrincipal = QHBoxLayout()
        
        componente_principal = QWidget()
        componente_principal.setLayout(layoutPrincipal)
        self.setCentralWidget(componente_principal)
       
        layout_vertical = QVBoxLayout()
        layout_vertical.addWidget(QPushButton('V1'))
        layout_vertical.addWidget(QPushButton('V2'))
        layout_vertical.addWidget(QPushButton('V3'))
        layout_vertical.addWidget(QPushButton('V4'))
        
        layout_horizontal = QHBoxLayout()
        layout_horizontal.addWidget(QPushButton('H1'))
        layout_horizontal.addWidget(QPushButton('H2'))
        layout_horizontal.addWidget(QPushButton('H3'))
        layout_horizontal.addWidget(QPushButton('H4'))
                 
        layoutPrincipal.addLayout(layout_vertical)
        layoutPrincipal.addLayout(layout_horizontal)
        
  
       
app = QApplication([])
ventana = VentanaPrincipal()
ventana.show()
app.exec()