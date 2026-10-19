# Comprensión del diseño — Enunciado C
**Nombre:** Daniel Andrés Chacón Olaya
**Fecha:** 19/10/2026

Responde con tus palabras, basándote en `docs/UML-final.md`. Respuestas
concisas (2–4 líneas por pregunta). Evidencia que entendiste el contrato
**antes** de programar.

---

### 1. Herencia y polimorfismo
¿Por qué `Curso` es una clase abstracta y no concreta? Menciona qué método
obliga a cada subclase a implementar y qué gana el sistema con eso.

> _RTA: Es abstracta porque se refiere a una clase en general en donde no se le puede agregar atributos, mientras que en concreto, es mas especifico que atributos se obtienen de esa clase; el metodo que obliga a implementarse es "Curso(codigo, nombre, creditos)", esto ayuda al sistema para crear los objetos con el mismo metodo pero diferente comportamiento.

---

### 2. Composición vs. agregación
Explica la diferencia entre `PlanEstudios ◆— Curso` (composición) y
`Facultad ◇— PlanEstudios` (agregación). ¿Qué pasaría con los cursos si se
elimina el plan? ¿Y con los planes si se elimina la facultad?

> _RTA: La diferencia entre la composición y la agrgación se evidencia cuando el objeto Curso depende del objeto padre PlanEstudios, mientras que Facultad es independiente de este, al eliminar los planes, el objeto Curso dejaria de "existir" o funcionar porque no hay ningun atributo o metodo que no comparta de él. Pero el objeto Facultad sigue funcionando de forma independiente, solo son dos objetos que se pueden complementar mucho mas pero sin la necesidad de depender uno del otro asi llegando a la siguiente cuestion, la eliminacion del objeto facultad, como anteriormente se dijo Facultad y PlanEstudios son totalmente independientes no pasa nada si se borran solo quedan desasociados._

---

### 3. Asociación
En `Estudiante — Curso`, ¿quién es dueño de quién? ¿Por qué se modela como
N:M y no como composición?

> _RTA: En este caso inguno es dueño de otro porque se trata de una relacion o independencia uno del otro, estamos hablando de una asociacion bidireccional o libre, siendo asi uno sea eliminado, el otro sigue existiendo sin afectarlo de una manera u otra. Se modela como N:M porque Estudiante puede tener muchos cursos y Curso puede tener muchos estudiantes; hacen parte uno del otro pero existir sin el otro al mismo tiempo (no depender)._

---

### 4. Dependencia
¿Por qué `Recomendador` **depende** de `HistorialAcademico` en lugar de
**tenerlo** como atributo? ¿Qué ventaja tiene pasar el servicio como
parámetro?

> _RTA: Depende porque esta linea "recomendar(h:HistorialAcademico):List<Curso>" necesita de los datos que son arrojados por HistorialAcademico; no estamos hablando de ser dueño uno del otro sino de solo para la unica tarea de calcular y en lugar de tenerlo como un atributo estructural radica en los principios de diseño de software, específicamente en el acoplamiento y la gestión del estado. _

---

### 5. Listas
En este proyecto se usan dos estructuras distintas:
- `int[] notas` en `Estudiante`
- `ArrayList<Curso>` en `PlanEstudios` y `Estudiante`

Explica por qué en cada caso se eligió esa estructura y no la otra. ¿Qué
pasa si el estudiante intenta registrar más notas que la capacidad del
arreglo?

> _RTA: Se elige un arreglo tradicional ([]) porque las notas suelen corresponder a una cantidad fija y conocida de evaluaciones (por ejemplo, los 3 cortes de un semestre o un número determinado de materias ya cursadas). Por otro lado, almacenar datos en un arreglo consume menos memoria y el acceso a cada posición es directo y extremadamente rápido mediante su índice. 
> Se elige un ArrayList porque la cantidad de cursos es dinámica. Un plan de estudios puede actualizarse agregando nuevas materias, y un estudiante inscribe un número variable de cursos cada semestre. Tambien el ArrayList maneja su tamaño de forma automática, permitiendo añadir (add()) o remover (remove()) elementos sin preocuparse por un límite inicial.
> Si el código intenta asignar una nota en un índice que supera el tamaño definido del arreglo (por ejemplo, intentar guardar la nota en la posición [5] de un arreglo de tamaño 5, cuyos índices válidos van del 0 al 4), ocurrirá lo siguiente: El programa lanzará inmediatamente una excepción en tiempo de ejecución. Específicamente, se arrojará un ArrayIndexOutOfBoundsException.Si esta excepción no es capturada y manejada (mediante un bloque try-catch), el hilo de ejecución se detendrá y el programa se frustrará o "caerá" de forma inesperada.
