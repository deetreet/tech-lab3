package com.example.Application.Services;

import com.example.Application.Dto.CatDto;
import com.example.Application.Dto.CatDtoMapper;
import com.example.Application.Exceptions.MyException;
import com.example.Application.Models.Cat;
import com.example.Application.Repositories.CatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Class realizing the service to interact with cat entities
 */
@RequiredArgsConstructor
@Service
public class CatService {
    private final CatRepository catRepository;
    private final CatDtoMapper catDtoMapper;

    /**
     * Method to add a cat to the database
     * @param catDto cat to be added
     */
    public void addCat(CatDto catDto) {
        if (catDto.getName() == null || catDto.getName().isEmpty()) {
            throw new MyException("Name cannot be empty");
        } else if (catDto.getBreed() == null) {
            throw new MyException("Breed cannot be empty");
        } else if (catDto.getOwnerId() == null) {
            throw new MyException("Owner cannot be empty");
        } else if (catDto.getDateOfBirth() == null) {
            throw new MyException("Date of birth cannot be empty");
        }

        try{
            Cat cat = catDtoMapper.catToEntity(catDto);
            catRepository.save(cat);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to delete a cat from the database
     * @param catId id of cat to be deleted
     */
    public void deleteCat(Integer catId) {
        try{
            Cat cat = catRepository.findById(catId).orElseThrow();
            catRepository.delete(cat);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to change the name of a cat
     * @param catId id of cat to be changed
     * @param newName new name of the cat
     */
    public void changeCatsName(Integer catId, String newName) {
        try{
            if (newName == null || newName.isEmpty()) {
                throw new MyException("New name cannot be empty");
            }
            Cat cat = catRepository.findById(catId).orElseThrow();
            cat.setName(newName);
            catRepository.save(cat);
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to get a cat by its id
     * @param catId id of cat to be found
     * @return Cat with the given id
     */
    public CatDto getCatById(Integer catId) {
        try{
            CatDto catDto = catDtoMapper.catToDto(catRepository.findById(catId).orElseThrow());
            return catDto;
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to get all friends of a cat
     * @param catId id of cat whose friends are to be found
     * @return List of friends of the cat
     */
    public List<CatDto> getCatsFriends(Integer catId) {
        try {
            Cat cat = catRepository.findById(catId).orElseThrow();
            List<CatDto> friends = cat
                    .getFriends()
                    .stream()
                    .map(friend -> catDtoMapper.catToDto(friend))
                    .toList();

            return friends;
        } catch (Exception exception) {
            throw exception;
        }
    }

    /**
     * Method to make a new friendship between two cats
     * @param firstCatId id of the first cat
     * @param secondCatId id of the second cat
     */
    public void makeNewFriendship(Integer firstCatId, Integer secondCatId) {
        try {
            Cat firstCat = catRepository.findById(firstCatId).orElseThrow();
            Cat secondCat = catRepository.findById(secondCatId).orElseThrow();
            firstCat.getFriends().add(secondCat);
            secondCat.getFriends().add(firstCat);
            catRepository.save(firstCat);
            catRepository.save(secondCat);
        } catch (Exception exception) {
            throw exception;
        }
    }

    public List<CatDto> getCatsByColorId(Integer colorId) {
        try {
            List<CatDto> catDtos = catRepository.findCatsByColorId(colorId)
                    .stream()
                    .map(cat -> catDtoMapper.catToDto(cat))
                    .toList();

            return catDtos;
        } catch (Exception exception) {
            throw exception;
        }
    }
}
