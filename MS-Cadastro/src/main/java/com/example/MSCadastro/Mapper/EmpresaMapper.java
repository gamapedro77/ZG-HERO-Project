package com.example.MSCadastro.Mapper;

import com.example.MSCadastro.DTO.EmpresaDto;
import com.example.MSCadastro.model.Empresa;
import org.mapstruct.Mapper;

import org.mapstruct.factory.Mappers;


@Mapper
public abstract class EmpresaMapper {
    public static final EmpresaMapper INSTANCE = Mappers.getMapper(EmpresaMapper.class);


    public abstract Empresa toEmpresa(EmpresaDto empresaDto);

    public abstract EmpresaDto toEmpresaDto(Empresa empresa);
}
