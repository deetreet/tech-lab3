package com.example.Application.Services;

import com.example.Application.Dto.OwnerDto;
import com.example.Application.Dto.OwnerDtoMapper;
import com.example.Application.Models.Owner;
import com.example.Application.Repositories.OwnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * Class realizing the service to interact with owner entities
 */
@RequiredArgsConstructor
@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final OwnerDtoMapper ownerDtoMapper;

    /**
     * Method to add an owner to the database
     * @param ownerDto owner to be added
     */
    public void addOwner(OwnerDto ownerDto) {
        try {
            Owner owner = ownerDtoMapper.ownerToEntity(ownerDto);
            ownerRepository.save(owner);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to delete an owner from the database
     * @param ownerId id of owner to be deleted
     */
    public void deleteOwner(Integer ownerId) {
        try {
            Owner owner = ownerRepository.findById(ownerId).orElseThrow();
            ownerRepository.delete(owner);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to get an owner by its id
     * @param ownerId id of owner to be found
     * @return Owner with the given id
     */
    public OwnerDto getOwnerById(Integer ownerId) {
        try {
            OwnerDto ownerDto = ownerDtoMapper.ownerToDto(ownerRepository.findById(ownerId).orElseThrow());
            return ownerDto;
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to get an owner by its name
     * @param name name of owner to be found
     * @return Owner with the given name
     */
    public OwnerDto getOwnerByName(String name) {
        try {
            OwnerDto ownerDto = ownerDtoMapper.ownerToDto(ownerRepository.findOwnerByName(name));
            return ownerDto;
        } catch (Exception exception) {
            throw exception;
        }
    }
}
