package com.anxin.annotation_compiler;

import com.anxin.annotation.module.ModuleRouter;
import com.anxin.annotation.view.BindView;
import com.google.auto.service.AutoService;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;

/**
 * Created by anxin on 2018/2/8.
 * <p>
 */

@AutoService(Processor.class)
final class ProcessorImp extends AbstractProcessor {

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }

    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> supports = new LinkedHashSet<>();
        supports.add(BindView.class.getCanonicalName());
        supports.add(ModuleRouter.class.getCanonicalName());
        return supports;
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        //parse ModuleRouter
        for (Element tElement : roundEnvironment.getElementsAnnotatedWith(ModuleRouter.class)) {

        }

        //parse BindView
        for (Element tElement : roundEnvironment.getElementsAnnotatedWith(BindView.class)) {

        }




        return false;
    }
}
