package cristian.com.cristian.restApi.model;

import java.util.List;

import cristian.com.cristian.pojo.Mascota;

/**
 * Created
 */
public class MascotaResponse {


    private List<Mascota> mascotas;


    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
