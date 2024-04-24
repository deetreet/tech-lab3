/*
import ApplicationData.MainApplication;
import ApplicationData.Models.Cat;
import ApplicationData.Models.Owner;
import ApplicationData.Repositories.CatRepository;
import ApplicationData.Repositories.OwnerRepository;
import lombok.Setter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.Optional;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@Setter
@SpringBootTest(classes = MainApplication.class)
public class DataLayerTest {
    @MockBean
    private CatRepository catRepository;

    @MockBean
    private OwnerRepository ownerRepository;

    private Cat Barsik = new Cat();
    private Owner Leha = new Owner();

    @Before
    public void Setup(){
        Barsik.setName("Barsik");
        Barsik.setBreed("Sphinx");
        Barsik.setDateOfBirth(new Date());
        Barsik.setColorId(1);

        Leha.setName("Leha");
        Leha.setDateOfBirth(new Date());
        Leha.getCats().add(Barsik);
    }

    @Test
    public void tryToAddCatAndGetItById_ShouldReturnCat(){
        when(catRepository.save(Barsik)).thenReturn(Barsik);
        when(catRepository.findById(1)).thenReturn(Optional.of(Barsik));

        catRepository.save(Barsik);
        Optional<Cat> expectedBarsik = catRepository.findById(1);

        verify(catRepository, Mockito.times(1)).save(Barsik);
        assertTrue(expectedBarsik.isPresent());
    }

    @Test
    public void tryToDeleteCat_ShouldDeleteCat(){catRepository.save(Barsik);
        catRepository.delete(Barsik);

        verify(catRepository, Mockito.times(1)).save(Barsik);
    }

    @Test
    public void tryToAddOwnerAndGetItById_ShouldReturnOwner(){
        when(ownerRepository.save(Leha)).thenReturn(Leha);
        when(ownerRepository.findById(1)).thenReturn(Optional.of(Leha));

        ownerRepository.save(Leha);
        Optional<Owner> expectedLeha = ownerRepository.findById(1);

        verify(ownerRepository, Mockito.times(1)).save(Leha);
        assertTrue(expectedLeha.isPresent());
    }
}*/
