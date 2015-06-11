package com.yutax77.java8_ans.chap8.ans13;

import static java.util.stream.Collectors.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes({"com.yutax77.java8_ans.chap8.ans13.TestCases", "com.yutax77.java8_ans.chap8.ans13.TestCase"})
public class TestCaseAnnotationProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        Map<String, Set<Element>> fqcnMap = new HashMap<>();
        for(TypeElement t: annotations) {
            Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(t);
            for(Element e: elements) {
                String fqcn = ((TypeElement)e.getEnclosingElement()).getQualifiedName().toString();
                fqcnMap.computeIfAbsent(fqcn, k -> new HashSet<>()).add(e);
            }
            
        }
        
        System.out.println("---- process -------");
        System.out.println(fqcnMap);
        
        fqcnMap.forEach((k, v) -> {
            try {
                writeIntoFile(k, v);
            } catch (IOException e) {
                e.printStackTrace();
            }
            
        });
        return true;
    }
    
    private void writeIntoFile(String fqcn, Set<? extends Element> elements) throws IOException {
        int last = fqcn.lastIndexOf(".");
        String packageName = fqcn.substring(0, last);
        String className = fqcn.substring(last + 1, fqcn.length());
        
        JavaFileObject sourceFile = processingEnv.getFiler().createSourceFile(className + "Test");
        try(PrintWriter out = new PrintWriter(sourceFile.openWriter())) {
            out.println("package " + packageName + ";");
            out.print("public class ");
            out.println(className + "Test {");
            out.println("    public static void main(String[] args) {");
            out.println("        " + className + " clazz = new " + className + "();");
            out.println("        int actual = 0;");
            out.println();
            
            elements.forEach(e -> {
                TestCase[] cases = e.getAnnotationsByType(TestCase.class);
                System.out.println("---------elements---------");
                System.out.println(e);
                System.out.println(((TypeElement)e.getEnclosingElement()).getQualifiedName());
                System.out.println(Arrays.toString(cases));
                
                for(TestCase testCase: cases) {
                    String name = e.getSimpleName().toString();
                    int param = testCase.params();
                    int expected = testCase.expected();
                    
                    out.println("        actual = clazz." + name + "(" + param + ");");
                    out.println("        if(actual == " + testCase.expected() + ") {");
                    out.println("            System.out.println(\"OK:" + name + "@param=" + param + "\");");
                    out.println("        } else {");
                    out.println("            System.out.println(\"" + String.format("NG:%s@param=%d. Expected(%d) but actual(\"", name, param, expected) + " + actual + \")\");");
                    out.println("        }");
                    out.println();
                }
            });
            
            out.println("    }");
            out.println("}");
        }
    }
}
