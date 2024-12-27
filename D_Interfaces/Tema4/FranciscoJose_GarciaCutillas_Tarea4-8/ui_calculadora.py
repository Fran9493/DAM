# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'calculadoraZsvNZt.ui'
##
## Created by: Qt User Interface Compiler version 6.6.0
##
## WARNING! All changes made in this file will be lost when recompiling UI file!
################################################################################

from PySide6.QtCore import (QCoreApplication, QDate, QDateTime, QLocale,
    QMetaObject, QObject, QPoint, QRect,
    QSize, QTime, QUrl, Qt)
from PySide6.QtGui import (QBrush, QColor, QConicalGradient, QCursor,
    QFont, QFontDatabase, QGradient, QIcon,
    QImage, QKeySequence, QLinearGradient, QPainter,
    QPalette, QPixmap, QRadialGradient, QTransform)
from PySide6.QtWidgets import (QApplication, QFormLayout, QHBoxLayout, QLabel,
    QLineEdit, QMainWindow, QMenuBar, QPushButton,
    QRadioButton, QSizePolicy, QSpacerItem, QStatusBar,
    QVBoxLayout, QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(336, 258)
        sizePolicy = QSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(MainWindow.sizePolicy().hasHeightForWidth())
        MainWindow.setSizePolicy(sizePolicy)
        MainWindow.setMaximumSize(QSize(336, 258))
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        sizePolicy1 = QSizePolicy(QSizePolicy.Preferred, QSizePolicy.Preferred)
        sizePolicy1.setHorizontalStretch(0)
        sizePolicy1.setVerticalStretch(0)
        sizePolicy1.setHeightForWidth(self.centralwidget.sizePolicy().hasHeightForWidth())
        self.centralwidget.setSizePolicy(sizePolicy1)
        self.horizontalLayout = QHBoxLayout(self.centralwidget)
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.formLayout = QFormLayout()
        self.formLayout.setObjectName(u"formLayout")
        self.formLayout.setLabelAlignment(Qt.AlignCenter)
        self.formLayout.setHorizontalSpacing(10)
        self.formLayout.setVerticalSpacing(12)
        self.formLayout.setContentsMargins(-1, -1, 15, -1)
        self.verticalSpacer_4 = QSpacerItem(20, 25, QSizePolicy.Minimum, QSizePolicy.Fixed)

        self.formLayout.setItem(0, QFormLayout.FieldRole, self.verticalSpacer_4)

        self.labelValor1 = QLabel(self.centralwidget)
        self.labelValor1.setObjectName(u"labelValor1")
        self.labelValor1.setAlignment(Qt.AlignHCenter|Qt.AlignTop)

        self.formLayout.setWidget(1, QFormLayout.LabelRole, self.labelValor1)

        self.lineEditValor1 = QLineEdit(self.centralwidget)
        self.lineEditValor1.setObjectName(u"lineEditValor1")

        self.formLayout.setWidget(1, QFormLayout.FieldRole, self.lineEditValor1)

        self.labelValor2 = QLabel(self.centralwidget)
        self.labelValor2.setObjectName(u"labelValor2")
        self.labelValor2.setAlignment(Qt.AlignHCenter|Qt.AlignTop)

        self.formLayout.setWidget(2, QFormLayout.LabelRole, self.labelValor2)

        self.lineEditValor2 = QLineEdit(self.centralwidget)
        self.lineEditValor2.setObjectName(u"lineEditValor2")

        self.formLayout.setWidget(2, QFormLayout.FieldRole, self.lineEditValor2)

        self.labelResultado = QLabel(self.centralwidget)
        self.labelResultado.setObjectName(u"labelResultado")
        self.labelResultado.setAlignment(Qt.AlignHCenter|Qt.AlignTop)

        self.formLayout.setWidget(3, QFormLayout.LabelRole, self.labelResultado)

        self.lineEditResultado = QLineEdit(self.centralwidget)
        self.lineEditResultado.setObjectName(u"lineEditResultado")
        self.lineEditResultado.setReadOnly(True)

        self.formLayout.setWidget(3, QFormLayout.FieldRole, self.lineEditResultado)

        self.verticalSpacer_3 = QSpacerItem(20, 20, QSizePolicy.Minimum, QSizePolicy.Fixed)

        self.formLayout.setItem(4, QFormLayout.FieldRole, self.verticalSpacer_3)

        self.botonCalcular = QPushButton(self.centralwidget)
        self.botonCalcular.setObjectName(u"botonCalcular")

        self.formLayout.setWidget(5, QFormLayout.FieldRole, self.botonCalcular)


        self.horizontalLayout.addLayout(self.formLayout)

        self.verticalLayout_2 = QVBoxLayout()
        self.verticalLayout_2.setObjectName(u"verticalLayout_2")
        self.verticalLayout_2.setContentsMargins(-1, 15, -1, -1)
        self.labelOperaciones = QLabel(self.centralwidget)
        self.labelOperaciones.setObjectName(u"labelOperaciones")

        self.verticalLayout_2.addWidget(self.labelOperaciones)

        self.verticalLayout = QVBoxLayout()
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.verticalLayout.setContentsMargins(10, 10, -1, -1)
        self.radioButtonSumar = QRadioButton(self.centralwidget)
        self.radioButtonSumar.setObjectName(u"radioButtonSumar")

        self.verticalLayout.addWidget(self.radioButtonSumar)

        self.radioButtonRestar = QRadioButton(self.centralwidget)
        self.radioButtonRestar.setObjectName(u"radioButtonRestar")

        self.verticalLayout.addWidget(self.radioButtonRestar)

        self.radioButtonMultiplicar = QRadioButton(self.centralwidget)
        self.radioButtonMultiplicar.setObjectName(u"radioButtonMultiplicar")

        self.verticalLayout.addWidget(self.radioButtonMultiplicar)

        self.radioButtonDividir = QRadioButton(self.centralwidget)
        self.radioButtonDividir.setObjectName(u"radioButtonDividir")

        self.verticalLayout.addWidget(self.radioButtonDividir)

        self.verticalSpacer_2 = QSpacerItem(20, 40, QSizePolicy.Minimum, QSizePolicy.Expanding)

        self.verticalLayout.addItem(self.verticalSpacer_2)


        self.verticalLayout_2.addLayout(self.verticalLayout)


        self.horizontalLayout.addLayout(self.verticalLayout_2)

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 336, 22))
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"Calculadora 2", None))
        self.labelValor1.setText(QCoreApplication.translate("MainWindow", u"Valor 1", None))
        self.labelValor2.setText(QCoreApplication.translate("MainWindow", u"Valor 2", None))
        self.labelResultado.setText(QCoreApplication.translate("MainWindow", u"Resultado", None))
        self.botonCalcular.setText(QCoreApplication.translate("MainWindow", u"Calcular", None))
        self.labelOperaciones.setText(QCoreApplication.translate("MainWindow", u"Operaciones", None))
        self.radioButtonSumar.setText(QCoreApplication.translate("MainWindow", u"Sumar", None))
        self.radioButtonRestar.setText(QCoreApplication.translate("MainWindow", u"Restar", None))
        self.radioButtonMultiplicar.setText(QCoreApplication.translate("MainWindow", u"Multiplicar", None))
        self.radioButtonDividir.setText(QCoreApplication.translate("MainWindow", u"Dividir", None))
    # retranslateUi

