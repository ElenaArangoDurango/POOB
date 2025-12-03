package hotel;

public class Hotel {

    private Habitacion[] habitaciones;

    public Hotel() {
        habitaciones = new Habitacion[10];

        for (int i = 0; i < 10; i++) {
            double precio = (i < 5) ? 120000 : 160000;
            habitaciones[i] = new Habitacion(i + 1, precio);
        }
    }

    public Habitacion[] getHabitaciones() {
        return habitaciones;
    }

    public Habitacion getHabitacion(int numero) {
        if (numero < 1 || numero > 10) return null;
        return habitaciones[numero - 1];
    }
}
