package domain.use_cases;

import com.example.loadfiletoawscloud.domain.port.PortFile;
import com.example.loadfiletoawscloud.domain.use_case.UploadFile;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

//@ExtendWith(SpringExtension.class)
class UploadFileTest {

//    @InjectMocks
//    private UploadFile uploadFile;
//
//    @Mock
//    private PortFile portFile;
//
//    private MultipartFile file;
//    @BeforeEach
//    void setUp() {
//        file = new MultipartFile("./test");
//        MockitoAnnotations.openMocks(this);
//    }
//
//    @Test
//    void excute() {
//        Assert.hasText("fichier enregistrer avec seccés",uploadFile.excute(file));
//    }
}