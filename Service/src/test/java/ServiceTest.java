/*
import ApplicationData.Models.Cat;
import ApplicationData.Models.Owner;
import ApplicationData.Repositories.CatRepository;
import ApplicationData.Repositories.OwnerRepository;
import ApplicationService.Dto.CatDto;
import ApplicationService.Dto.OwnerDto;
import ApplicationService.MainApplication;
import ApplicationService.Services.CatService;
import ApplicationService.Services.OwnerService;
import lombok.Setter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Setter
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class ServiceTest {
    @Mock
    private CatRepository catRepository;


    @Mock
    private OwnerRepository ownerRepository;

    //@Autowired
    private CatService catService;

    // @Autowired
    private OwnerService ownerService;

    private CatDto Barsik = new CatDto();
    private OwnerDto Leha = new OwnerDto();

    @Before
    public void Setup(){
        MockitoAnnotations.initMocks(this);

        Barsik.setName("Barsik");
        Barsik.setBreed("Sphinx");
        Barsik.setDateOfBirth("08-04-2021");
        Barsik.setColorId(1);

        Leha.setName("Leha");
        Leha.setDateOfBirth("08-04-2021");


        Cat EntityBarsik = new Cat();
        EntityBarsik.setCatId(1);
        EntityBarsik.setName(Barsik.getName());
        EntityBarsik.setBreed(Barsik.getBreed());
        EntityBarsik.setDateOfBirth(new Date());
        EntityBarsik.setColorId(Barsik.getColorId());

        Owner EntityLeha = new Owner();
        EntityLeha.setOwnerId(1);
        EntityLeha.setName(Leha.getName());
        EntityLeha.setDateOfBirth(new Date());
        EntityLeha.getCats().add(EntityBarsik);

        EntityBarsik.setOwner(EntityLeha);
        EntityLeha.setCats(List.of(EntityBarsik));

        when(catRepository.save(any(Cat.class))).thenReturn(EntityBarsik);
        when(catRepository.findById(anyInt())).thenReturn(Optional.of(EntityBarsik));
        when(ownerRepository.save(any(Owner.class))).thenReturn(EntityLeha);
        when(ownerRepository.findById(anyInt())).thenReturn(Optional.of(EntityLeha));
    }

    @Test
    public void tryToAddCatAndGetItById_ShouldReturnCat(){
        catService.addCat(Barsik);
        CatDto expectedBarsik = catService.getCatById(1);

        verify(catRepository, Mockito.times(1)).save(any(Cat.class));
        verify(catRepository, Mockito.times(1)).findById(anyInt());
        assertTrue(expectedBarsik.getBreed() == Barsik.getBreed()
                && expectedBarsik.getName() == Barsik.getName()
            && expectedBarsik.getColorId() == Barsik.getColorId()
            && expectedBarsik.getDateOfBirth() == Barsik.getDateOfBirth()
            && expectedBarsik.getOwnerId() == Barsik.getOwnerId());
    }

    @Test
    public void tryToDeleteCat_ShouldDeleteCat(){
        catService.deleteCat(1);

        verify(catRepository, Mockito.times(1)).findById(anyInt());
        verify(catRepository, Mockito.times(1)).delete(any(Cat.class));
    }

    @Test
    public void tryToAddOwnerAndGetItById_ShouldReturnOwner(){
        ownerService.addOwner(Leha);
        OwnerDto expectedLeha = ownerService.getOwnerById(1);

        verify(ownerRepository, Mockito.times(1)).save(any(Owner.class));
        verify(ownerRepository, Mockito.times(1)).findById(anyInt());
        assertTrue(expectedLeha.getName() == Leha.getName()
            && expectedLeha.getDateOfBirth() == Leha.getDateOfBirth()
            && expectedLeha.getCatIds().containsAll(Leha.getCatIds()));
    }
}

*/
