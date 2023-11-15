import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private List<Producto> productos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    private JFrame frame;
    private DefaultTableModel tableModel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Main().createAndShowGUI();
        });
    }

    private void createAndShowGUI() {
        frame = new JFrame("Aplicación de Pedidos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = createInputPanel();
        frame.add(inputPanel, BorderLayout.NORTH);

  
        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Producto");
        tableModel.addColumn("Cliente");
        tableModel.addColumn("Cantidad");
        tableModel.addColumn("Fecha de Pedido");
        tableModel.addColumn("Fecha de Recojo");

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton saveButton = new JButton("Guardar");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarInformacion();
            }
        });

        frame.add(saveButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 4));

   
        JTextField productoTextField = new JTextField();
        JTextField precioTextField = new JTextField();
        JButton agregarProductoButton = new JButton("Agregar Producto");

        agregarProductoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarProducto(productoTextField.getText(), Double.parseDouble(precioTextField.getText()));
            }
        });

  
        JTextField nombreClienteTextField = new JTextField();
        JTextField telefonoClienteTextField = new JTextField();
        JButton agregarClienteButton = new JButton("Agregar Cliente");

        agregarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente(nombreClienteTextField.getText(), telefonoClienteTextField.getText());
            }
        });


        panel.add(new JLabel("Producto:"));
        panel.add(productoTextField);
        panel.add(new JLabel("Precio:"));
        panel.add(precioTextField);
        panel.add(agregarProductoButton);

        panel.add(new JLabel("Nombre Cliente:"));
        panel.add(nombreClienteTextField);
        panel.add(new JLabel("Teléfono Cliente:"));
        panel.add(telefonoClienteTextField);
        panel.add(agregarClienteButton);

        return panel;
    }

    private void agregarProducto(String nombre, double precio) {
        Producto producto = new Producto(nombre, precio);
        productos.add(producto);
        JOptionPane.showMessageDialog(frame, "Producto agregado: " + producto.nombre);
    }

    private void agregarCliente(String nombre, String telefono) {
        Cliente cliente = new Cliente(nombre, telefono, "");
        clientes.add(cliente);
        JOptionPane.showMessageDialog(frame, "Cliente agregado: " + cliente.nombre);
    }

    private void guardarInformacion() {

        Pedido pedido = new Pedido(1, productos, 2, new Date(), new Date(), clientes.get(0));

        tableModel.addRow(new Object[]{
                pedido.id,
                pedido.productos.get(0).nombre,
                pedido.cliente.nombre,
                pedido.cantidad,
                pedido.fechaPedido,
                pedido.fechaRecojo
        });

        JOptionPane.showMessageDialog(frame, "Información guardada correctamente");
    }
}
