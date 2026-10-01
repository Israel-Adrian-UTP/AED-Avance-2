//CLASE PRINCIPAL
public class Avance2 {
    public static void main(String[] args) {
        //LISTA ENLAZADA
        ListaRepuesto ListaRepuesto = new ListaRepuesto();
        //REPUESTOS REGISTRADOS
        ListaRepuesto.RegistrarRepuesto(1, "R101", "Regulador Alta Presion", 10);
        ListaRepuesto.RegistrarRepuesto(2, "R102", "Regulador Baja Presion", 41);
        ListaRepuesto.RegistrarRepuesto(3, "R103", "Manguera Alta Presion", 31);
        ListaRepuesto.RegistrarRepuesto(4, "R104", "Manguera Baja Presion", 45);
        ListaRepuesto.RegistrarRepuesto(5, "R105", "Quemador Marca Bosh", 8);
        //MOSTRAR REPUESTOS
        System.out.println("LISTA DE REPUESTOS:");
        ListaRepuesto.MostrarRepuesto();
        //BUSCAR REPUESTO
        System.out.println("BUSQUEDA:");
        ListaRepuesto.BuscarRepuesto(3);
        //ACTUALIZAR REPUESTO
        System.out.println("ACTUALIZAR:");
        ListaRepuesto.ActualizarRepuesto(3, "R103", "Manguera Alta Presion Premiun", 40);
        ListaRepuesto.MostrarRepuesto();
        //ELIMINAR REPUESTO
        System.out.println("ELIMINAR:");
        ListaRepuesto.EliminarRepuesto(3);
        ListaRepuesto.MostrarRepuesto();
        //ORDENAR REPUESTO
        System.out.println("ORDENAR:");
        ListaRepuesto.OrdenarRepuesto();
        ListaRepuesto.MostrarRepuesto();
    }
}

//CLASE NODO
class Nodo{
    //ATRIBUTOS
    int Id;
    String Codigo;
    String Nombre;
    int Existencia;
    Nodo Siguiente;
    //CONSTRUCTOR
    public Nodo(int Id, String Codigo, String Nombre, int Existencia){
        this.Id = Id;
        this.Codigo = Codigo;
        this.Nombre = Nombre;
        this.Existencia = Existencia;
        this.Siguiente = null;
    } 
    
}
//CLASE LISTA
class ListaRepuesto{
    Nodo Cabeza;
    public ListaRepuesto(){
        Cabeza = null;
    }
    //REGISTRAR REPUESTO
    public void RegistrarRepuesto(int Id, String Codigo, String Nombre, int Existencia){
        Nodo Nuevo = new Nodo(Id,Codigo,Nombre,Existencia);
        if (Cabeza == null) {
            Cabeza = Nuevo;
        } else {
            Nodo Auxiliar = Cabeza;
            while(Auxiliar.Siguiente != null) {
                Auxiliar = Auxiliar.Siguiente;
            }
            Auxiliar.Siguiente = Nuevo;
        }
        System.out.println("Repuesto registrado correctamente.");
    }
    //MOSTRAR REPUESTO
    public void MostrarRepuesto(){
        if(Cabeza == null) {
            System.out.println("NO EXISTEN REPUESTOS.");
            return;
        }
        Nodo Auxiliar = Cabeza;
        while(Auxiliar != null) {
            System.out.println(Auxiliar.Id + " - " + Auxiliar.Codigo + " - " + Auxiliar.Nombre + " - " + Auxiliar.Existencia);
            Auxiliar = Auxiliar.Siguiente;
        }
    }
    //BUSCAR REPUESTO
    public void BuscarRepuesto(int Id){
        Nodo Auxiliar = Cabeza;
        while(Auxiliar != null) {
            if(Auxiliar.Id == Id) {
                System.out.println("REPUESTO ENCONTRADO.");
                System.out.println(Auxiliar.Id + " - " + Auxiliar.Codigo + " - " + Auxiliar.Nombre + " - " + Auxiliar.Existencia);
                return;
            }
            Auxiliar = Auxiliar.Siguiente;
        }
        System.out.println("REPUESTO NO ENCONTRADO.");
    }
    //ACTUALIZAR REPUESTO
    public void ActualizarRepuesto(int Id,String NuevoCodigo, String NuevoNombre, int NuevoExistencia){
        Nodo Auxiliar = Cabeza;
        while(Auxiliar != null) {
            if(Auxiliar.Id == Id) {
                Auxiliar.Codigo = NuevoCodigo;
                Auxiliar.Nombre = NuevoNombre;
                Auxiliar.Existencia = NuevoExistencia;
                System.out.println("DATOS ACTUALIZADOS.");
                return;
            }
            Auxiliar = Auxiliar.Siguiente;
        }
        System.out.println("REPUESTO NO ENCONTRADO.");
    }
    //ELIMINAR REPUESTO
    public void EliminarRepuesto(int Id){
        if(Cabeza == null) {
            System.out.println("LA LISTA ESTA VACIA.");
            return;
        }
        if(Cabeza.Id == Id) {
            Cabeza = Cabeza.Siguiente;
            System.out.println("REPUESTO ELIMINADO.");
            return;
        }
        Nodo Actual = Cabeza;
        Nodo Anterior = null;
        while(Actual != null && Actual.Id != Id) {
            Anterior = Actual;
            Actual = Actual.Siguiente;
        }
        if(Actual != null) {
            Anterior.Siguiente = Actual.Siguiente;
            System.out.println("REPUESTO ELIMINADO.");
        } else {
            System.out.println("REPUESTO NO ENCONTRADO.");
        }
    }
    //ORDENAR REPUESTO
    public void OrdenarRepuesto(){
        if (Cabeza == null || Cabeza.Siguiente == null) {
            System.out.println("NO HAY REPUESTOS PARA ORDENAR.");
            return;
        }
        Nodo Ordenada = null;
        Nodo Actual = Cabeza;
        while (Actual != null) {
            Nodo Siguiente = Actual.Siguiente;
            if (Ordenada == null || Actual.Id >= Ordenada.Id) {
                Actual.Siguiente = Ordenada;
                Ordenada = Actual;
            } else {
                Nodo Temp = Ordenada;
                while (Temp.Siguiente != null && Temp.Siguiente.Id < Actual.Id) {
                    Temp = Temp.Siguiente;
                }
                Actual.Siguiente = Temp.Siguiente;
                Temp.Siguiente = Actual;
            }
            Actual = Siguiente;
        }
        Cabeza = Ordenada;
    }
}