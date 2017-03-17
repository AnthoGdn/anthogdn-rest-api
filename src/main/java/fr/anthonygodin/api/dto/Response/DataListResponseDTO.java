package fr.anthonygodin.api.dto.Response;

import fr.anthonygodin.api.dto.EntityDTO;

/**
 * Created by AnthoGdn on 16/03/17.
 */
public class DataListResponseDTO<E extends EntityDTO> implements ResponseDTO {

    private Iterable<E> data;

    public Iterable<E> getData() {
        return data;
    }
    public void setData(Iterable<E> data) {
        this.data = data;
    }
}