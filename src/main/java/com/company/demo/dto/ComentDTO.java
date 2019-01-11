package com.company.demo.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class ComentDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private Date date;
    private AuthorDTO authorDTO;

    public ComentDTO() {
    }

    public ComentDTO(String id, Date date, AuthorDTO authorDTO) {
        this.id = id;
        this.date = date;
        this.authorDTO = authorDTO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public AuthorDTO getAuthorDTO() {
        return authorDTO;
    }

    public void setAuthorDTO(AuthorDTO authorDTO) {
        this.authorDTO = authorDTO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComentDTO comentDTO = (ComentDTO) o;
        return id.equals(comentDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
