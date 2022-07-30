package inonu.hrms.api.controllers;

import inonu.hrms.business.abstracts.WebsiteTypeService;
import inonu.hrms.core.utilities.results.DataResult;
import inonu.hrms.core.utilities.results.Result;
import inonu.hrms.entities.tables.WebsiteType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/website-types")
public class WebsiteTypesController {

    private WebsiteTypeService websiteTypeService;

    @Autowired
    public WebsiteTypesController(WebsiteTypeService websiteTypeService) {
        this.websiteTypeService = websiteTypeService;
    }

    @GetMapping("")
    public ResponseEntity<DataResult<List<WebsiteType>>> getAll(){
        return new ResponseEntity<>(this.websiteTypeService.getAll(), HttpStatus.OK);
    }

    @PostMapping("save")
    public ResponseEntity<Result> save(@Valid @RequestBody WebsiteType websiteType){
        Result result = this.websiteTypeService.save(websiteType);

        if(!result.isSuccess()) {
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
