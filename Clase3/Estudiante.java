public class Estudiante{

    //Atributos

    private int id;
    private int cedula;
    private String nombre;
    private String facultad

    //Constructor
    public Estudiante(int id, int cedula, string nombre, string facultad){
        this.id = id
        this.cedula = cedula;
        this.nombre = nombre;
        this.facultad = facultad;
    }

    //Metodo Matricular cursos
    public void matricularCusros(String[] cursos){
        System.out.println(Arrays.toString(cursos))
    }

    //Metodo toString 
    public  String toString(){
        return "Estudiante: [id: " + id + "Cedúla: " + cedula + " Nombre: " + nombre + "Facultad: " + facultad + "]";
    }

}