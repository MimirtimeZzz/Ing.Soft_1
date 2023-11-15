import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Pedido {
    int id;
    List<Producto> productos;
    int cantidad;
    Date fechaPedido;
    Date fechaRecojo;
    Cliente cliente;

    public Pedido(int id, List<Producto> productos, int cantidad, Date fechaPedido, Date fechaRecojo, Cliente cliente) {
        this.id = id;
        this.productos = productos;
        this.cantidad = cantidad;
        this.fechaPedido = fechaPedido;
        this.fechaRecojo = fechaRecojo;
        this.cliente = cliente;
    }
}