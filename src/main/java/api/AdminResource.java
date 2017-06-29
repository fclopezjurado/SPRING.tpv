package api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.exceptions.YamlFileNotFoundException;
import controllers.AdminController;

@RestController
@RequestMapping(Uris.VERSION + Uris.ADMINS)
public class AdminResource {

    private AdminController adminController;

    @Autowired
    public void setAdminController(AdminController adminController) {
        this.adminController = adminController;
    }

    //TODO revisar
    @RequestMapping(method = RequestMethod.GET)
    public String version(String param) {
        return "{\"version\":\"" + Uris.VERSION + "\"}";
    }

    @RequestMapping(value = Uris.ADMINS_DATABASE, method = RequestMethod.POST)
    public void seedDatabase(@RequestBody(required = false) String ymlFileName) throws YamlFileNotFoundException {
        if (ymlFileName == null || ymlFileName.isEmpty()) {
            adminController.seedDatabase();
        } else {
            if (!adminController.existsYamlFile(ymlFileName)) {
                throw new YamlFileNotFoundException();
            } else {
                adminController.seedDatabase(ymlFileName);
            }
        }
    }

    @RequestMapping(value = Uris.ADMINS_DATABASE, method = RequestMethod.DELETE)
    public void deleteAllExceptAdmin() {
        adminController.deleteAllExceptAdmin();
    }

}
