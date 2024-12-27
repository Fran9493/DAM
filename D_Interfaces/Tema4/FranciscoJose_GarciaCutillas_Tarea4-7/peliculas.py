# -*- coding: utf-8 -*-

################################################################################
## Form generated from reading UI file 'peliculasbCleox.ui'
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
    QLineEdit, QListWidget, QListWidgetItem, QMainWindow,
    QMenuBar, QPushButton, QSizePolicy, QSpacerItem,
    QStatusBar, QVBoxLayout, QWidget)
import Recursos

class Ui_MainWindow(object):
    def setupUi(self, MainWindow):
        if not MainWindow.objectName():
            MainWindow.setObjectName(u"MainWindow")
        MainWindow.resize(447, 311)
        sizePolicy = QSizePolicy(QSizePolicy.Fixed, QSizePolicy.Fixed)
        sizePolicy.setHorizontalStretch(0)
        sizePolicy.setVerticalStretch(0)
        sizePolicy.setHeightForWidth(MainWindow.sizePolicy().hasHeightForWidth())
        MainWindow.setSizePolicy(sizePolicy)
        MainWindow.setMaximumSize(QSize(447, 311))
        icon = QIcon()
        icon.addFile(u":/iconos/movie.png", QSize(), QIcon.Normal, QIcon.Off)
        MainWindow.setWindowIcon(icon)
        self.centralwidget = QWidget(MainWindow)
        self.centralwidget.setObjectName(u"centralwidget")
        sizePolicy.setHeightForWidth(self.centralwidget.sizePolicy().hasHeightForWidth())
        self.centralwidget.setSizePolicy(sizePolicy)
        self.verticalLayout_3 = QVBoxLayout(self.centralwidget)
        self.verticalLayout_3.setObjectName(u"verticalLayout_3")
        self.verticalLayout_2 = QVBoxLayout()
        self.verticalLayout_2.setObjectName(u"verticalLayout_2")
        self.formLayout = QFormLayout()
        self.formLayout.setObjectName(u"formLayout")
        self.label = QLabel(self.centralwidget)
        self.label.setObjectName(u"label")

        self.formLayout.setWidget(0, QFormLayout.LabelRole, self.label)

        self.label_2 = QLabel(self.centralwidget)
        self.label_2.setObjectName(u"label_2")
        sizePolicy1 = QSizePolicy(QSizePolicy.Preferred, QSizePolicy.Fixed)
        sizePolicy1.setHorizontalStretch(0)
        sizePolicy1.setVerticalStretch(0)
        sizePolicy1.setHeightForWidth(self.label_2.sizePolicy().hasHeightForWidth())
        self.label_2.setSizePolicy(sizePolicy1)
        self.label_2.setAlignment(Qt.AlignCenter)

        self.formLayout.setWidget(0, QFormLayout.FieldRole, self.label_2)

        self.verticalLayout = QVBoxLayout()
        self.verticalLayout.setObjectName(u"verticalLayout")
        self.verticalLayout.setContentsMargins(20, 0, 20, -1)
        self.verticalSpacer_2 = QSpacerItem(20, 13, QSizePolicy.Minimum, QSizePolicy.Fixed)

        self.verticalLayout.addItem(self.verticalSpacer_2)

        self.linePeliculas = QLineEdit(self.centralwidget)
        self.linePeliculas.setObjectName(u"linePeliculas")
        sizePolicy2 = QSizePolicy(QSizePolicy.Maximum, QSizePolicy.Fixed)
        sizePolicy2.setHorizontalStretch(0)
        sizePolicy2.setVerticalStretch(0)
        sizePolicy2.setHeightForWidth(self.linePeliculas.sizePolicy().hasHeightForWidth())
        self.linePeliculas.setSizePolicy(sizePolicy2)

        self.verticalLayout.addWidget(self.linePeliculas)

        self.verticalSpacer = QSpacerItem(20, 20, QSizePolicy.Minimum, QSizePolicy.Fixed)

        self.verticalLayout.addItem(self.verticalSpacer)

        self.botonAdd = QPushButton(self.centralwidget)
        self.botonAdd.setObjectName(u"botonAdd")
        sizePolicy.setHeightForWidth(self.botonAdd.sizePolicy().hasHeightForWidth())
        self.botonAdd.setSizePolicy(sizePolicy)
        self.botonAdd.setMaximumSize(QSize(100, 16777215))
        self.botonAdd.setLayoutDirection(Qt.LeftToRight)
        icon1 = QIcon()
        icon1.addFile(u":/iconos/add.png", QSize(), QIcon.Normal, QIcon.Off)
        self.botonAdd.setIcon(icon1)
        self.botonAdd.setIconSize(QSize(13, 13))

        self.verticalLayout.addWidget(self.botonAdd)


        self.formLayout.setLayout(1, QFormLayout.LabelRole, self.verticalLayout)

        self.listPeliculas = QListWidget(self.centralwidget)
        self.listPeliculas.setObjectName(u"listPeliculas")

        self.formLayout.setWidget(1, QFormLayout.FieldRole, self.listPeliculas)


        self.verticalLayout_2.addLayout(self.formLayout)

        self.horizontalLayout = QHBoxLayout()
        self.horizontalLayout.setObjectName(u"horizontalLayout")
        self.pushButton = QPushButton(self.centralwidget)
        self.pushButton.setObjectName(u"pushButton")
        icon2 = QIcon()
        icon2.addFile(u":/iconos/check.png", QSize(), QIcon.Normal, QIcon.Off)
        self.pushButton.setIcon(icon2)

        self.horizontalLayout.addWidget(self.pushButton, 0, Qt.AlignHCenter)

        self.pushButton_2 = QPushButton(self.centralwidget)
        self.pushButton_2.setObjectName(u"pushButton_2")
        icon3 = QIcon()
        icon3.addFile(u":/iconos/brush.png", QSize(), QIcon.Normal, QIcon.Off)
        self.pushButton_2.setIcon(icon3)

        self.horizontalLayout.addWidget(self.pushButton_2, 0, Qt.AlignHCenter)


        self.verticalLayout_2.addLayout(self.horizontalLayout)


        self.verticalLayout_3.addLayout(self.verticalLayout_2)

        MainWindow.setCentralWidget(self.centralwidget)
        self.menubar = QMenuBar(MainWindow)
        self.menubar.setObjectName(u"menubar")
        self.menubar.setGeometry(QRect(0, 0, 447, 22))
        MainWindow.setMenuBar(self.menubar)
        self.statusbar = QStatusBar(MainWindow)
        self.statusbar.setObjectName(u"statusbar")
        MainWindow.setStatusBar(self.statusbar)

        self.retranslateUi(MainWindow)

        QMetaObject.connectSlotsByName(MainWindow)
    # setupUi

    def retranslateUi(self, MainWindow):
        MainWindow.setWindowTitle(QCoreApplication.translate("MainWindow", u"Pel\u00edculas", None))
        self.label.setText(QCoreApplication.translate("MainWindow", u"Escribe el t\u00edtulo de una pel\u00edcula", None))
        self.label_2.setText(QCoreApplication.translate("MainWindow", u"Pel\u00edculas", None))
        self.botonAdd.setText(QCoreApplication.translate("MainWindow", u"A\u00f1adir", None))
        self.pushButton.setText(QCoreApplication.translate("MainWindow", u"Aceptar", None))
        self.pushButton_2.setText(QCoreApplication.translate("MainWindow", u"Limpiar", None))
    # retranslateUi

