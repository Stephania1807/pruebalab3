package com.example.pruebalab3.Controllers;

import com.example.pruebalab3.Entity.Departments;
import com.example.pruebalab3.Entity.Employees;
import com.example.pruebalab3.Repository.DepartmentsRepository;
import com.example.pruebalab3.Repository.EmployeesRepository;
import com.example.pruebalab3.Repository.JobsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeesRepository employeesRepository;

    @Autowired
    JobsRepository jobsRepository;

    @Autowired
    DepartmentsRepository departmentsRepository;
    @GetMapping(value = {"","/"})
    public String listaEmployee(Model model){
        model.addAttribute("listaEmployee", employeesRepository.findAll());
        model.addAttribute("listaJobs", jobsRepository.findAll());
        model.addAttribute("listaDepartments", departmentsRepository.findAll());
        return "Employee/lista";
    }
    @GetMapping("/new")
    public String nuevoEmployeeForm(@ModelAttribute("employees") Employees employees, Model model) {
        model.addAttribute("listaDepartaments", departmentsRepository.findAll());
        model.addAttribute("listaJobs", jobsRepository.findAll());

        List<Departments> departmentOpt = departmentsRepository.findAll();
        List<Departments> departamentosFinales = new ArrayList<Departments>();
        for (Departments i : departmentOpt){
            if(i.getManagerid() != null){
                departamentosFinales.add(i);
            }
        }
        model.addAttribute("listaDepartamentosconJefes", departamentosFinales);

        return "Employee/newform";
    }

    @PostMapping("/guardar")
    public String guardarEmployee(@RequestParam("managerid") int manager,Employees employee, RedirectAttributes redirectAttributes) {
        Optional<Employees> employei= employeesRepository.findById(manager);
        employee.setManagerid(employei.get());
        if (employee.getEmployeeid() == 0) {
            redirectAttributes.addFlashAttribute("msg1", "Empleado creado exitosamente");
        } else {
            redirectAttributes.addFlashAttribute("msg2", "Empleado actualizado exitosamente");
        }
        employeesRepository.save(employee);
        return "redirect:/employee";
    }
}
