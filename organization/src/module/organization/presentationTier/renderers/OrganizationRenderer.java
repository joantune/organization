/*
 * @(#)OrganizationManagementAction.java
 *
 * Copyright 2009 Instituto Superior Tecnico
 * Founding Authors: João Figueiredo, Luis Cruz, Paulo Abrantes, Susana Fernandes
 * 
 *      https://fenix-ashes.ist.utl.pt/
 * 
 *   This file is part of the Organization Module for the MyOrg web application.
 *
 *   The Organization Module is free software: you can redistribute it and/or modify
 *   it under the terms of the GNU Lesser General Public License as published
 *   by the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version.*
 *
 *   The Organization Module is distributed in the hope that it will be useful,
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 *   GNU Lesser General Public License for more details.
 *
 *   You should have received a copy of the GNU Lesser General Public License
 *   along with the Organization Module. If not, see <http://www.gnu.org/licenses/>.
 * 
 */

package module.organization.presentationTier.renderers;

import java.util.Comparator;

import module.organization.domain.Party;
import module.organization.domain.PartyPredicate;
import module.organization.presentationTier.renderers.decorators.LinkablePartyDecorator;
import module.organization.presentationTier.renderers.decorators.PartyDecorator;
import module.organization.presentationTier.renderers.layouts.OrganizationLayout;
import pt.ist.fenixWebFramework.renderers.OutputRenderer;
import pt.ist.fenixWebFramework.renderers.layouts.Layout;

public class OrganizationRenderer extends OutputRenderer {

    private String rootClasses = "tree";
    private String childListStyle = "display:none";

    private String blankImage = "/organization/images/blank.gif";
    private String minusImage = "/organization/images/minus.gif";
    private String plusImage = "/organization/images/plus.gif";

    public String getRootClasses() {
	return rootClasses;
    }

    public void setRootClasses(String rootClasses) {
	this.rootClasses = rootClasses;
    }

    public String getChildListStyle() {
	return childListStyle;
    }

    public void setChildListStyle(String childListStyle) {
	this.childListStyle = childListStyle;
    }

    public String getBlankImage() {
	return blankImage;
    }

    public void setBlankImage(String blankImage) {
	this.blankImage = blankImage;
    }

    public String getMinusImage() {
	return minusImage;
    }

    public void setMinusImage(String minusImage) {
	this.minusImage = minusImage;
    }

    public String getPlusImage() {
	return plusImage;
    }

    public void setPlusImage(String plusImage) {
	this.plusImage = plusImage;
    }

    @Override
    protected Layout getLayout(final Object object, final Class clazz) {
	// TODO: refactor to have any layout?
	return new OrganizationLayout(this);
    }

    public PartyDecorator getDecorator() {
	// TODO: make this configurable
	return new LinkablePartyDecorator();
    }

    public PartyPredicate getPartyPredicate() {
	// TODO: make this configurable
	return new PartyPredicate.TruePartyPredicate();
    }

    public Comparator<Party> getSortBy() {
	// TODO: make this configurable
	return Party.COMPARATOR_BY_NAME;
    }
}