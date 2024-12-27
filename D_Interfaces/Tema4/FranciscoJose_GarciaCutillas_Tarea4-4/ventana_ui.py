# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'ventana.ui'
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
from PySide6.QtWidgets import (QApplication, QHBoxLayout, QLabel, QLineEdit,
    QMainWindow, QPushButton, QSizePolicy, QStatusBar,
    QVBoxLayout, QWidget)

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(474, 159)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        self.verticalLayout = QVBoxLayout(self.centralwidget)
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.label = QLabel(self.centralwidget)
        self.label.setObjectName(u"label")

        self.horizontalLayout.addWidget(self.label)

        self.campoContador = QLineEdit(self.centralwidget)
        self.campoContador.setObjectName(u"campoContador")
        self.campoContador.setReadOnly(True)

        self.horizontalLayout.addWidget(self.campoContador)

        self.CountUp = QPushButton(self.centralwidget)
        self.CountUp.setObjectName(u"CountUp")

        self.horizontalLayout.addWidget(self.CountUp)

        self.CountDown = QPushButton(self.centralwidget)
        self.CountDown.setObjectName(u"CountDown")

        self.horizontalLayout.addWidget(self.CountDown)

        self.Reset = QPushButton(self.centralwidget)
        self.Reset.setObjectName(u"Reset")

        self.horizontalLayout.addWidget(self.Reset)


        self.verticalLayout.addLayout(self.horizontalLayout)

        MainWindow.setCentralWidget(self.centralwidget)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"Contador", None))
        self.label.setText(QCoreApplication.translate("MainWindow", u"Contador", None))
        self.campoContador.setText(QCoreApplication.translate("MainWindow", u"0", None))
        self.CountUp.setText(QCoreApplication.translate("MainWindow", u"Count Up", None))
        self.CountDown.setText(QCoreApplication.translate("MainWindow", u"Count Down", None))
        self.Reset.setText(QCoreApplication.translate("MainWindow", u"Reset", None))
    # retranslateUi

