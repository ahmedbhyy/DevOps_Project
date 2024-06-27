package tn.esprit.devops_project.services;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.mock.mockito.MockBean;
import tn.esprit.devops_project.repositories.ActivitySectorRepository;

import tn.esprit.devops_project.entities.ActivitySector;

import javax.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class ActivitySectorImplTest {
    @Autowired
    private ActivitySectorImpl activitySectorService;

    @MockBean
    private ActivitySectorRepository activitySectorRepository;

    @Test
    void retrieveAllActivitySectors() {
        ActivitySector activitySector1 = new ActivitySector();
        activitySector1.setCodeSecteurActivite("Code1");
        activitySector1.setLibelleSecteurActivite("Libelle1");

        ActivitySector activitySector2 = new ActivitySector();
        activitySector2.setCodeSecteurActivite("Code2");
        activitySector2.setLibelleSecteurActivite("Libelle2");

        // Act
        activitySectorService.addActivitySector(activitySector1);
        activitySectorService.addActivitySector(activitySector2);

        List<ActivitySector> result = activitySectorService.retrieveAllActivitySectors();

        // Assert
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains(activitySector1));
        assertTrue(result.contains(activitySector2));

    }

    @Test
    void addActivitySector() {

        // Arrange
        ActivitySector activitySector = new ActivitySector();
        activitySector.setCodeSecteurActivite("Code");
        activitySector.setLibelleSecteurActivite("Libelle");

        // Act
        ActivitySector result = activitySectorService.addActivitySector(activitySector);

        // Assert
        assertNotNull(result);
        assertNotNull(result.getIdSecteurActivite());
        assertEquals("Code", result.getCodeSecteurActivite());
        assertEquals("Libelle", result.getLibelleSecteurActivite());


    }

    @Test
    void deleteActivitySector() {
        // Arrange
        ActivitySector activitySector = new ActivitySector();
        activitySector.setCodeSecteurActivite("Code");
        activitySector.setLibelleSecteurActivite("Libelle");
        ActivitySector savedActivitySector = activitySectorService.addActivitySector(activitySector);

        // Act
        activitySectorService.deleteActivitySector(savedActivitySector.getIdSecteurActivite());

        // Assert
        assertThrows(IllegalArgumentException.class,
                () -> activitySectorService.retrieveActivitySector(savedActivitySector.getIdSecteurActivite()));
    }

    @Test
    void updateActivitySector() {

        // Arrange
        ActivitySector activitySector = new ActivitySector();
        activitySector.setCodeSecteurActivite("Code");
        activitySector.setLibelleSecteurActivite("Libelle");
        ActivitySector savedActivitySector = activitySectorService.addActivitySector(activitySector);

        // Act
        savedActivitySector.setCodeSecteurActivite("UpdatedCode");
        savedActivitySector.setLibelleSecteurActivite("UpdatedLibelle");
        ActivitySector updatedActivitySector = activitySectorService.updateActivitySector(savedActivitySector);

        // Assert
        assertNotNull(updatedActivitySector);
        assertEquals("UpdatedCode", updatedActivitySector.getCodeSecteurActivite());
        assertEquals("UpdatedLibelle", updatedActivitySector.getLibelleSecteurActivite());
    }


   // methode retrieve all avec junit
    @Test
    void retrieveActivitySector() {
        // Arrange
        ActivitySector activitySector = new ActivitySector();
        activitySector.setCodeSecteurActivite("Code");
        activitySector.setLibelleSecteurActivite("Libelle");
        ActivitySector savedActivitySector = activitySectorService.addActivitySector(activitySector);

        // Act
        ActivitySector result = activitySectorService.
                retrieveActivitySector(savedActivitySector.getIdSecteurActivite());

        // Assert
        assertNotNull(result);
        assertEquals(savedActivitySector, result);
    }



}
