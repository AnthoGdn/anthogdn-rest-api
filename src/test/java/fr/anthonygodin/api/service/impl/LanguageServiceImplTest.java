package fr.anthonygodin.api.service.impl;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

/**
 * Created by AnthoGdn on 16/03/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class LanguageServiceImplTest {
/*
    @Mock
    private LanguageRepository languageRepository;
    private LanguageServiceImpl languageService;

    public LanguageServiceImplTest() {
        super();
    }

    private final static String LANGUAGE_ID_1 = UUID.randomUUID().toString();
    private final static String LANGUAGE_NAME_1 = "JAVA";
    private final static Language.Level LANGUAGE_LEVEL_1 = Language.Level.GOOD;
    private final static String LANGUAGE_URL_1 = "localhost:8080/public/java.png";
    private final static int LANGUAGE_ORDER_1 = 1;

    private final static String LANGUAGE_ID_2 = UUID.randomUUID().toString();
    private final static String LANGUAGE_NAME_2 = "PHP";
    private final static Language.Level LANGUAGE_LEVEL_2 = Language.Level.MIDDLE;
    private final static String LANGUAGE_URL_2 = "localhost:8080/public/php.png";
    private final static int LANGUAGE_ORDER_2 = 2;

    @Before
    public void setUp() throws Exception {
        languageService = new LanguageServiceImpl(languageRepository);
    }

    @Test
    public void createLanguageIsOk() throws Exception {
        // Expected objects
        Language persistedLanguage = new Language(
                LANGUAGE_ID_1, LANGUAGE_NAME_1, LANGUAGE_LEVEL_1, LANGUAGE_URL_1, LANGUAGE_ORDER_1
        );
        LanguageToCreateDTO languageToSaveDTO = new LanguageToCreateDTO(persistedLanguage);

        // Mockito expectations
        when(languageRepository.save(persistedLanguage)).thenReturn(persistedLanguage);

        // Execute the method being tested
        LanguageDTO createdLanguage = languageService.create(languageToSaveDTO);

        // Validation
        assertThat(createdLanguage.getId()).isNotNull();
        assertThat(createdLanguage.getName()).isEqualTo(languageToSaveDTO.getName());
        assertThat(createdLanguage.getImgURL()).isEqualTo(languageToSaveDTO.getImgURL());
        assertThat(createdLanguage.getLevel()).isEqualTo(languageToSaveDTO.getLevel());

        verify(languageRepository).save(persistedLanguage);
    }

    @Test
    public void deleteLanguageIsOk() throws Exception {
        Language persistedLanguage = new Language(
                LANGUAGE_ID_1, LANGUAGE_NAME_1, LANGUAGE_LEVEL_1, LANGUAGE_URL_1, LANGUAGE_ORDER_1
        );

        // Mockito expectations
        when(languageRepository.findOne(LANGUAGE_ID_1)).thenReturn(persistedLanguage);
        // Execute the method being tested
        languageService.delete(LANGUAGE_ID_1);
        verify(languageRepository).delete(LANGUAGE_ID_1);
    }

    @Test
    public void deleteLanguageThrowsNotFoundRESTExceptionTest() throws Exception {
        Language persistedLanguage = new Language(
                LANGUAGE_ID_1, LANGUAGE_NAME_1, LANGUAGE_LEVEL_1, LANGUAGE_URL_1, LANGUAGE_ORDER_1
        );

        // Mockito expectations
        when(languageRepository.findOne(LANGUAGE_ID_1)).thenReturn(null);
        // Execute the method being tested
        try {
            languageService.delete(LANGUAGE_ID_1);
        } catch (RESTException exception) {
            toVerifyNotFoundException(exception);
            return;
        }
        assertThat(false).isTrue();
    }

    @Test
    public void deleteAllLanguageIsOk() throws Exception {
        // Execute the method being tested
        languageService.deleteAll();
        verify(languageRepository).deleteAll();
    }


    @Test
    public void findAllWithOneLanguagesIsOk() throws Exception {
        List<Language> languagesFoundInMock = new LinkedList<Language>();
        Language persistedLanguage = new Language(
                LANGUAGE_ID_1, LANGUAGE_NAME_1, LANGUAGE_LEVEL_1, LANGUAGE_URL_1, LANGUAGE_ORDER_1
        );
        languagesFoundInMock.add(persistedLanguage);

        // Mockito expectations
        when(languageRepository.findAll()).thenReturn(languagesFoundInMock);

        // Execute the method being tested
        Sort sort = new Sort(Sort.Direction.ASC, "orderBy");
        Pageable pageable = new PageRequest(0,10, sort);
        Page<Language> languageListDTOFound = languageService.findAll(pageable);

        // Validation
        assertThat(languageListDTOFound.getContent().size()).isEqualTo(languagesFoundInMock.size());

        Language languageFound = languageListDTOFound.getContent().get(0);
        assertThat(languageFound.getId()).isEqualTo(persistedLanguage.getId());
        assertThat(languageFound.getName()).isEqualTo(persistedLanguage.getName());
        assertThat(languageFound.getImgURL()).isEqualTo(persistedLanguage.getImgURL());
        assertThat(languageFound.getLevel()).isEqualTo(persistedLanguage.getLevel());

        verify(languageRepository).findAll();
    }

    @Test
    public void findAllWithTwoLanguagesIsOk() throws Exception {
        List<Language> languagesFoundInMock = new LinkedList<Language>();
        addLanguageToList(languagesFoundInMock,
                LANGUAGE_ID_1, LANGUAGE_NAME_1, LANGUAGE_LEVEL_1, LANGUAGE_URL_1, LANGUAGE_ORDER_1
        );
        addLanguageToList(languagesFoundInMock,
                LANGUAGE_ID_2, LANGUAGE_NAME_2, LANGUAGE_LEVEL_2, LANGUAGE_URL_2, LANGUAGE_ORDER_2
        );

        // Mockito expectations
        when(languageRepository.findAll()).thenReturn(languagesFoundInMock);

        // Execute the method being tested
        Sort sort = new Sort(Sort.Direction.ASC, "orderBy");
        Pageable pageable = new PageRequest(0,10, sort);
        Page<Language> languageListDTOFound = languageService.findAll(pageable);

        // Validation
        assertThat(languageListDTOFound.getContent().size()).isEqualTo(languagesFoundInMock.size());

        Language languageFound_1 = languageListDTOFound.getContent().get(0);
        Language languageFound_2 = languageListDTOFound.getContent().get(1);

        assertThat(languageFound_1.getId()).isEqualTo(LANGUAGE_ID_1);
        assertThat(languageFound_1.getName()).isEqualTo(LANGUAGE_NAME_1);
        assertThat(languageFound_1.getImgURL()).isEqualTo(LANGUAGE_URL_1);
        assertThat(languageFound_1.getLevel()).isEqualTo(LANGUAGE_LEVEL_1);

        assertThat(languageFound_2.getId()).isEqualTo(LANGUAGE_ID_2);
        assertThat(languageFound_2.getName()).isEqualTo(LANGUAGE_NAME_2);
        assertThat(languageFound_2.getImgURL()).isEqualTo(LANGUAGE_URL_2);
        assertThat(languageFound_2.getLevel()).isEqualTo(LANGUAGE_LEVEL_2);

        verify(languageRepository).findAll();
    }

    @Test
    public void findbyIdLanguagesIsOk() throws Exception {
        Language persistedLanguage = new Language(
                LANGUAGE_ID_1, LANGUAGE_NAME_1, LANGUAGE_LEVEL_1, LANGUAGE_URL_1, LANGUAGE_ORDER_1
        );

        // Mockito expectations
        when(languageRepository.findOne(LANGUAGE_ID_1)).thenReturn(persistedLanguage);

        // Execute the method being tested
        LanguageDTO languageDTOFound = languageService.findById(persistedLanguage.getId());

        // Validation
        assertThat(languageDTOFound.getId()).isEqualTo(persistedLanguage.getId());
        assertThat(languageDTOFound.getName()).isEqualTo(persistedLanguage.getName());
        assertThat(languageDTOFound.getImgURL()).isEqualTo(persistedLanguage.getImgURL());
        assertThat(languageDTOFound.getLevel()).isEqualTo(persistedLanguage.getLevel());

        verify(languageRepository).findOne(persistedLanguage.getId());
    }

    @Test
    public void findByIdLanguagesThrowsNotFoundRESTExceptionTest() throws Exception {
        Language persistedLanguage = new Language(
                LANGUAGE_ID_1, LANGUAGE_NAME_1, LANGUAGE_LEVEL_1, LANGUAGE_URL_1, LANGUAGE_ORDER_1
        );
        // Mockito expectations
        when(languageRepository.findOne(LANGUAGE_ID_1)).thenReturn(null);

        // Execute the method being tested
        try {
            languageService.findById(persistedLanguage.getId());
        } catch (RESTException exception) {
            // Validation
            toVerifyNotFoundException(exception);
            return;
        }
        assertThat(false).isTrue();
    }

    @Test
    public void updateLanguageIsOk() throws Exception {
        // Expected objects
        Language persistedLanguage = new Language(
                LANGUAGE_ID_1, LANGUAGE_NAME_1, LANGUAGE_LEVEL_1, LANGUAGE_URL_1, LANGUAGE_ORDER_1
        );
        Language updatedLanguage = new Language();
        updatedLanguage.setId(LANGUAGE_ID_1);
        updatedLanguage.setName(LANGUAGE_NAME_2);
        updatedLanguage.setImgURL(LANGUAGE_URL_2);
        updatedLanguage.setLevel(LANGUAGE_LEVEL_2);
//        updatedLanguage.setOrder(LANGUAGE_ORDER_2);

        LanguageDTO languageToUpdateDTO = new LanguageDTO(updatedLanguage);

        // Mockito expectations
        when(languageRepository.exists(LANGUAGE_ID_1)).thenReturn(true);
        when(languageRepository.save(updatedLanguage)).thenReturn(updatedLanguage);

        // Execute the method being tested
        LanguageDTO createdLanguage = languageService.update(languageToUpdateDTO);

        // Validation
        assertThat(createdLanguage.getId()).isNotNull();
        assertThat(createdLanguage.getName()).isEqualTo(languageToUpdateDTO.getName());
        assertThat(createdLanguage.getImgURL()).isEqualTo(languageToUpdateDTO.getImgURL());
        assertThat(createdLanguage.getLevel()).isEqualTo(languageToUpdateDTO.getLevel());

        verify(languageRepository).save(updatedLanguage);
    }

    @Test
    public void updateLanguageThrowsNotFoundRESTExceptionTest() throws Exception {
        // Expected objects
        Language updatedlanguage = new Language();
        updatedlanguage.setId(LANGUAGE_ID_1);
        updatedlanguage.setName(LANGUAGE_NAME_2);
        updatedlanguage.setImgURL(LANGUAGE_URL_2);
        updatedlanguage.setLevel(LANGUAGE_LEVEL_2);

        LanguageDTO languageToUpdateDTO = new LanguageDTO(updatedlanguage);

        // Mockito expectations
        when(languageRepository.exists(LANGUAGE_ID_1)).thenReturn(false);
        when(languageRepository.save(updatedlanguage)).thenReturn(updatedlanguage);

        // Execute the method being tested
        try {
            LanguageDTO createdLanguage = languageService.update(languageToUpdateDTO);
        } catch (RESTException exception) {
            toVerifyNotFoundException(exception);
            return;
        }
        assertThat(false).isTrue();
    }

// PRIVATE
    private void addLanguageToList(
            List<Language> languages, String id, String name, Language.Level level, String url, int orderNb
    ) {
        Language language = new Language(id, name, level, url, orderNb);
        languages.add(language);
    }

    private void toVerifyNotFoundException(RESTException exception) {
        assertThat(exception.getMessage()).isEqualTo(Error.LANGUAGE_NOT_FOUND.getMessage());
        assertThat(exception.getError()).isEqualTo(Error.LANGUAGE_NOT_FOUND);
    }*/
}
