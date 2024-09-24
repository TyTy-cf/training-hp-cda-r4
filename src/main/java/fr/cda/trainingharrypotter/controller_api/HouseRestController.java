package fr.cda.trainingharrypotter.controller_api;

import com.fasterxml.jackson.annotation.JsonView;
import fr.cda.trainingharrypotter.dto.HouseDTO;
import fr.cda.trainingharrypotter.entity.House;
import fr.cda.trainingharrypotter.json_views.JsonViews;
import fr.cda.trainingharrypotter.service.HouseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@AllArgsConstructor
@RequestMapping("/api/house")
public class HouseRestController {

    private HouseService houseService;

    @GetMapping
    @JsonView(JsonViews.HouseListView.class)
    public List<House> list() {
        return houseService.list();
    }

    @PostMapping
    public House create(@Valid @RequestBody HouseDTO dto) {
        return houseService.create(dto);
    }

    @GetMapping("/{search}")
    @JsonView(JsonViews.HouseShowView.class)
    public House search(@PathVariable String search) {
        return houseService.findBySearch(search);
    }

    @PutMapping("/{id}")
    public House update(@Valid @RequestBody HouseDTO dto, @PathVariable Integer id) {
        return houseService.update(dto, id);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Integer id) {
        houseService.delete(id);
        return true;
    }

}