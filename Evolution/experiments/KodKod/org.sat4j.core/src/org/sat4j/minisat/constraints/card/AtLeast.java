/*******************************************************************************
 * SAT4J: a SATisfiability library for Java Copyright (C) 2004, 2012 Artois University and CNRS
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 * Alternatively, the contents of this file may be used under the terms of
 * either the GNU Lesser General Public License Version 2.1 or later (the
 * "LGPL"), in which case the provisions of the LGPL are applicable instead
 * of those above. If you wish to allow use of your version of this file only
 * under the terms of the LGPL, and not to allow others to use your version of
 * this file under the terms of the EPL, indicate your decision by deleting
 * the provisions above and replace them with the notice and other provisions
 * required by the LGPL. If you do not delete the provisions above, a recipient
 * may use your version of this file under the terms of the EPL or the LGPL.
 *
 * Based on the original MiniSat specification from:
 *
 * An extensible SAT solver. Niklas Een and Niklas Sorensson. Proceedings of the
 * Sixth International Conference on Theory and Applications of Satisfiability
 * Testing, LNCS 2919, pp 502-518, 2003.
 *
 * See www.minisat.se for the original solver in C++.
 *
 * Contributors:
 *   CRIL - initial API and implementation
 *******************************************************************************/
package org.sat4j.minisat.constraints.card;

import java.io.Serializable;

import org.sat4j.minisat.constraints.cnf.Lits;
import org.sat4j.minisat.constraints.cnf.UnitClauses;
import org.sat4j.minisat.core.Constr;
import org.sat4j.minisat.core.ILits;
import org.sat4j.minisat.core.Propagatable;
import org.sat4j.minisat.core.Undoable;
import org.sat4j.minisat.core.UnitPropagationListener;
import org.sat4j.specs.ContradictionException;
import org.sat4j.specs.IVecInt;

/**
 * @author leberre Contrainte de cardinalit?
 */
public class AtLeast implements Propagatable, Constr, Undoable, Serializable {

    private static final long serialVersionUID = 1L;

    /** number of allowed falsified literal */
    protected int maxUnsatisfied;

    /** current number of falsified literals */
    private int counter;

    /**
     * constraint literals
     */
    protected final int[] lits;

    protected final ILits voc;

    /**
     * @param ps
     *            a vector of literals
     * @param degree
     *            the minimal number of satisfied literals
     */
    protected AtLeast(ILits voc, IVecInt ps, int degree) {
        this.maxUnsatisfied = ps.size() - degree;
        this.voc = voc;
        this.counter = 0;
        this.lits = new int[ps.size()];
        ps.moveTo(this.lits);
        for (int q : this.lits) {
            voc.watch(q ^ 1, this);
        }
    }

    protected static int niceParameters(UnitPropagationListener s, ILits voc,
            IVecInt ps, int deg) throws ContradictionException {

        if (ps.size() < deg) {
            throw new ContradictionException();
        }
        int degree = deg;
        for (int i = 0; i < ps.size();) {
            // on verifie si le litteral est affecte
            if (voc.isUnassigned(ps.get(i))) {
                // go to next literal
                i++;
            } else {
                // Si le litteral est satisfait,
                // ?a revient ? baisser le degr?
                if (voc.isSatisfied(ps.get(i))) {
                    degree--;
                }
                // dans tous les cas, s'il est assign?,
                // on enleve le ieme litteral
                ps.delete(i);
            }
        }

        // on trie le vecteur ps
        ps.sortUnique();
        // ?limine les clauses tautologiques
        // deux litt?raux de signe oppos?s apparaissent dans la m?me
        // clause

        if (ps.size() == degree) {
            for (int i = 0; i < ps.size(); i++) {
                if (!s.enqueue(ps.get(i))) {
                    throw new ContradictionException();
                }
            }
            return 0;
        }

        if (ps.size() < degree) {
            throw new ContradictionException();
        }
        return degree;

    }

    /**
     * @since 2.1
     */
    public static Constr atLeastNew(UnitPropagationListener s, ILits voc,
            IVecInt ps, int n) throws ContradictionException {
        int degree = niceParameters(s, voc, ps, n);
        if (degree == 0) {
            return new UnitClauses(ps);
        }
        return new AtLeast(voc, ps, degree);
    }

    /**
     * @since 2.1
     */
    public void remove(UnitPropagationListener upl) {
        for (int q : this.lits) {
            this.voc.watches(q ^ 1).remove(this);
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see Constr#propagate(Solver, Lit)
     */
    public boolean propagate(UnitPropagationListener s, int p) {
        // remet la clause dans la liste des clauses regardees
        this.voc.watch(p, this);

        if (this.counter == this.maxUnsatisfied) {
            return false;
        }

        this.counter++;
        this.voc.undos(p).push(this);

        // If no more can be false, enqueue the rest:
        if (this.counter == this.maxUnsatisfied) {
            for (int q : this.lits) {
                if (this.voc.isUnassigned(q) && !s.enqueue(q, this)) {
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Constr#simplify(Solver)
     */
    public boolean simplify() {
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Constr#undo(Solver, Lit)
     */
    public void undo(int p) {
        this.counter--;
    }

    /*
     * (non-Javadoc)
     * 
     * @see Constr#calcReason(Solver, Lit, Vec)
     */
    public void calcReason(int p, IVecInt outReason) {
        int c = p == ILits.UNDEFINED ? -1 : 0;
        for (int q : this.lits) {
            if (this.voc.isFalsified(q)) {
                outReason.push(q ^ 1);
                if (++c == this.maxUnsatisfied) {
                    return;
                }
            }
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.sat4j.minisat.datatype.Constr#learnt()
     */
    public boolean learnt() {
        // Ces contraintes ne sont pas apprises pour le moment.
        return false;
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.sat4j.minisat.datatype.Constr#getActivity()
     */
    public double getActivity() {
        return 0;
    }

    public void setActivity(double d) {
    }

    /*
     * (non-Javadoc)
     * 
     * @see org.sat4j.minisat.datatype.Constr#incActivity(double)
     */
    public void incActivity(double claInc) {
    }

    /*
     * For learnt clauses only @author leberre
     */
    public boolean locked() {
        // FIXME need to be adapted to AtLeast
        // return lits[0].getReason() == this;
        return true;
    }

    public void setLearnt() {
        throw new UnsupportedOperationException();
    }

    public void register() {
        throw new UnsupportedOperationException();
    }

    public int size() {
        return this.lits.length;
    }

    public int get(int i) {
        return this.lits[i];
    }

    public void rescaleBy(double d) {
        throw new UnsupportedOperationException();
    }

    public void assertConstraint(UnitPropagationListener s) {
        throw new UnsupportedOperationException();
    }

    /**
     * Textual representation of the constraint
     * 
     * @return a string representing the constraint.
     */
    @Override
    public String toString() {
        StringBuffer stb = new StringBuffer();
        stb.append("Card (" + this.lits.length + ") : ");
        for (int lit : this.lits) {
            // if (voc.isUnassigned(lits[i])) {
            stb.append(" + "); //$NON-NLS-1$
            stb.append(Lits.toString(lit));
            stb.append("[");
            stb.append(this.voc.valueToString(lit));
            stb.append("@");
            stb.append(this.voc.getLevel(lit));
            stb.append("]  ");
        }
        stb.append(">= "); //$NON-NLS-1$
        stb.append(size() - this.maxUnsatisfied);

        return stb.toString();
    }

    /**
     * @since 2.1
     */
    public void forwardActivity(double claInc) {
        // TODO Auto-generated method stub

    }

    public boolean canBePropagatedMultipleTimes() {
        return true;
    }

    public Constr toConstraint() {
        return this;
    }
}
