package fr.anthonygodin.api.dto.response;

import fr.anthonygodin.api.dto.entity.EntityDTO;

/**
 * Created by AnthoGdn on 16/03/17.
 */
public class DataResponseDTO<E extends EntityDTO> implements ResponseDTO {

    private E data;

    public E getData() {
        return data;
    }
    public void setData(E data) {
        this.data = data;
    }
}
