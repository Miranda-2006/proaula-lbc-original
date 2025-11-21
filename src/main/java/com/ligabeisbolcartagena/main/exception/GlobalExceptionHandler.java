package com.ligabeisbolcartagena.main.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public String handleMaxSizeException(MaxUploadSizeExceededException exc, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("errorMessage", "⚠️ El archivo supera el tamaño máximo permitido (64 MB)");
        // Redirige a la página donde ocurre la carga (puedes cambiar esta ruta según tu vista)
        return "redirect:/admin/agregar-jugador";
    }
}
