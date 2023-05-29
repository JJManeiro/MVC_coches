# Arquitectura MVC

Aplicación que trabaja con objetos coches, modifica la velocidad y la muestra

---
## Diagrama de clases:

```mermaid
classDiagram
Controller-->Model
Controller-->View
Model-->Coche
Model-->Oteador
Model-->View : Si getCoche no de resultado. 
Oteador-->View
View-->Dialog
View-->IU
IU-->Controller
Controller: main()
Controller: construir()
Controller: acelerar()
Controller: frenar()
Controller: filtro()
Controller: todos() 
Model: crearCoche()
Model: getCoche()
Model: acelerar()
Model: frenar()
Model: todos()
View: IU()
View: creado()
View: noHay()
View: pedir()
View: mostrarCoche()
View: aviso()
Coche: String modelo
Coche: String matricula
Coche: int velocidad
Coche: coche()
Oteador: update()
IU: IU()
IU: crear()
Dialog: Dialog()
Dialog: Main()
```

---

## Diagrama de Secuencia
El diagrama de secuencia con todos los métodos de controller y comose relacionan con los demás.

```mermaid
sequenceDiagram
    participant Model
    participant Controller
    participant View
    participant Oteador
    participant Dialog
    participant IU
    Controller->>Model: main MiModelo()
    Controller->>Oteador: main MiObserver()
    Model->>Oteador:MiModelo.addObserver(MiObserver)
    Controller->>View: main MiVista()
    View->>IU: IU.crear
    Controller->>Model: construir()
    activate Model
    Model -->>Controller: return aux
    deactivate Model
    Controller-->>View: creado()
    activate View
    View-->>Controller: JOPane(coche creado!)
    deactivate View
    Controller->>View: MiVista.mostrarCoche
    activate View
    View-->>Dialog: mostrarCoche()
    activate Dialog
    Dialog-->>View: main(mensaje)
    deactivate Dialog
    deactivate View
    activate Controller
    Controller-->>View: MiVista.pedir()
    activate View
    View-->>Controller: JOPane(m)
    Controller-->>View: MiVista.pedir()
    View-->>Controller: JOPane(m)
    deactivate View
    Controller->>Model: acelerar(m,v)
    deactivate Controller
    activate Model
    Model-->>Oteador: notifyObservers()
    deactivate Model
    activate Oteador
    Oteador-->>View: update()
    deactivate Oteador
    activate View
    View-->>Dialog: aviso(m)
    activate Dialog
    Dialog-->>View: main(m)
    deactivate Dialog
    deactivate View
    activate Controller
    Controller-->>View: MiVista.pedir()
    activate View
    View-->>Controller: JOPane(m)
    Controller-->>View: MiVista.pedir()
    View-->>Controller: JOPane(m)
    deactivate View
    Controller->>Model: frenar(m,v)
    deactivate Controller
    activate Model
    Model-->>Oteador: notifyObservers()
    deactivate Model
    activate Oteador
    Oteador-->>View: update()
    deactivate Oteador
    activate View
    View-->>Dialog: aviso(m)
    activate Dialog
    Dialog-->>View: main(m)
    deactivate Dialog
    deactivate View
    activate Controller
    Controller-->View: MiVista.pedir()
    activate View
    View-->Controller: JOPane(m)
    deactivate View
    Controller->>Model: getcoche(m)
    activate Model
    Model-->>View: en caso de que aux sea nulo. View.NoHay()
    activate View
    View-->>Controller: JOPane(No hay coche)
    deactivate View
    Model-->>Controller: return aux    
    deactivate Model    
    Controller->>View: MiVista.mostrarCoche()
    deactivate Controller
    activate View
    View-->>Dialog: mostrarCoche()
    activate Dialog
    Dialog-->>View: main(mensaje)
    deactivate Dialog
    deactivate View
    activate Controller
    Controller->>Model: MiModelo.todos()
    deactivate Controller
    activate Model
    Model-->>Controller: foreach(){sout ArrayList parking}
    deactivate Model    
```