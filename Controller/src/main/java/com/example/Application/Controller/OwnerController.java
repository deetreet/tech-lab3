package com.example.Application.Controller;

import com.example.Application.Dto.OwnerDto;
import com.example.Application.Services.OwnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * Controller to interact with owners
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    private final OwnerService ownerService;

    /**
     * Method to add an owner to the database
     *
     * @param owner owner to be added
     */
    @PostMapping("/add ")
    public void addOwner(@RequestBody OwnerDto owner) {
        ownerService.addOwner(owner);
    }

    /**
     * Method to delete an owner from the database
     *
     * @param ownerId id of owner to be deleted
     */
    @DeleteMapping("/delete/{ownerId}")
    public void deleteOwner(@PathVariable Integer ownerId) {
        ownerService.deleteOwner(ownerId);
    }

    /**
     * Method to get an owner by its id
     *
     * @param ownerId id of owner to be found
     * @return Owner with the given id
     */
    @GetMapping("/get/{ownerId}")
    public @ResponseBody OwnerDto getOwnerById(@PathVariable Integer ownerId) {
        return ownerService.getOwnerById(ownerId);
    }
}
