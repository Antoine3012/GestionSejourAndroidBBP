<?php

namespace App\Entity;

use App\Repository\SejourRepository;
use Doctrine\ORM\Mapping as ORM;

use ApiPlatform\Core\Annotation\ApiResource;

/**
 * @ApiResource()
 * @ORM\Entity(repositoryClass=SejourRepository::class)
 */
class Sejour
{
    /**
     * @ORM\Id
     * @ORM\GeneratedValue
     * @ORM\Column(type="integer")
     */
    private $id;

    /**
     * @ORM\Column(type="date", nullable=true)
     */
    private $dateArrivee;

    /**
     * @ORM\Column(type="date", nullable=true)
     */
    private $dateDepart;

    /**
     * @ORM\Column(type="string", length=255, nullable=true)
     */
    private $Commentaire;

    /**
     * @ORM\ManyToOne(targetEntity=Chambre::class)
     */
    private $numChambre;

    /**
     * @ORM\ManyToOne(targetEntity=Patient::class)
     */
    private $numPatient;

    /**
     * @ORM\Column(type="boolean")
     */
    private $validationDepart;

    /**
     * @ORM\Column(type="boolean")
     */
    private $validationEntree;

    public function getId(): ?int
    {
        return $this->id;
    }

    public function getDateArrivee(): ?\DateTimeInterface
    {
        return $this->dateArrivee;
    }

    public function setDateArrivee(?\DateTimeInterface $dateArrivee): self
    {
        $this->dateArrivee = $dateArrivee;

        return $this;
    }

    public function getDateDepart(): ?\DateTimeInterface
    {
        return $this->dateDepart;
    }

    public function setDateDepart(?\DateTimeInterface $dateDepart): self
    {
        $this->dateDepart = $dateDepart;

        return $this;
    }

    public function getCommentaire(): ?string
    {
        return $this->Commentaire;
    }

    public function setCommentaire(?string $Commentaire): self
    {
        $this->Commentaire = $Commentaire;

        return $this;
    }

    public function getNumChambre(): ?Chambre
    {
        return $this->numChambre;
    }

    public function setNumChambre(?Chambre $numChambre): self
    {
        $this->numChambre = $numChambre;

        return $this;
    }

    public function getNumPatient(): ?Patient
    {
        return $this->numPatient;
    }

    public function setNumPatient(?Patient $numPatient): self
    {
        $this->numPatient = $numPatient;

        return $this;
    }

    public function getValidationSortie(): ?bool
    {
        return $this->validationSortie;
    }

    public function setValidationSortie(bool $validationSortie): self
    {
        $this->validationSortie = $validationSortie;

        return $this;
    }

    public function getValidationEntree(): ?bool
    {
        return $this->validationEntree;
    }

    public function setValidationEntree(bool $validationEntree): self
    {
        $this->validationEntree = $validationEntree;

        return $this;
    }
}
