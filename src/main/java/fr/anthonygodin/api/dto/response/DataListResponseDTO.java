package fr.anthonygodin.api.dto.response;

import fr.anthonygodin.api.dto.entity.EntityDTO;
import org.springframework.data.domain.Page;

/**
 * Created by AnthoGdn on 16/03/17.
 */
public class DataListResponseDTO<E extends EntityDTO> implements ResponseDTO {

    private Page<E> data;

    public Page<E> getData() {
        return data;
    }
    public void setData(Page<E> data) {
        this.data = data;
    }
}