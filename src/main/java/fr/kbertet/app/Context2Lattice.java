package fr.kbertet.app;

import static org.kohsuke.args4j.OptionHandlerFilter.ALL;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import fr.kbertet.lattice.Context;
import fr.kbertet.lattice.ConceptLattice;

import java.io.File;
import java.io.IOException;

/*
 * Context2Lattice.java
 *
 * Copyright: 2010-2014 Karell Bertet, France
 *
 * License: http://www.cecill.info/licences/Licence_CeCILL-B_V1-en.html CeCILL-B license
 *
 * This file is part of java-lattices-bin, free package. You can redistribute it and/or modify
 * it under the terms of CeCILL-B license.
 */

/**
 * This class converts context file to lattice file in dot format.
 */
public class Context2Lattice {

    /**
     * output file.
     */
    @Option(name = "-o", usage = "output to this file", metaVar = "OUTPUT", aliases = {"--output" }, required = true)
    private File out;

    /**
     * input file.
     */
    @Option(name = "-i", usage = "input from this file", metaVar = "INPUT", aliases = {"--input" }, required = true)
    private File in;

    /**
     * Main method.
     *
     * @param   args  command line arguments
     */
    public static void main(String[] args) {
        new Context2Lattice().doMain(args);
    }

    /**
     * Execute command line arguments.
     *
     * @param   args  command line arguments
     */
    public void doMain(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        // if you have a wider console, you could increase the value;
        // here 80 is also the default
        parser.getProperties().withUsageWidth(80);

        try {
            // parse the arguments.
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            // if there's a problem in the command line,
            // you'll get this exception. this will report
            // an error message.
            System.err.println(e.getMessage());
            System.err.println("java Context2Lattice [options...]");
            // print the list of available options
            parser.printUsage(System.err);
            System.err.println();

            // print option sample. This is useful some time
            System.err.println("  Example: java Context2Lattice" + parser.printExample(ALL));

            return;
        }

        try {
            Context ctx = new Context(in.getPath());
            ConceptLattice lattice = ctx.lattice();
            lattice.save(out.getPath());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}

